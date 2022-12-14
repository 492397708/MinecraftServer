import { INSPECT_MAX_BYTES } from "buffer";

export default {
    getAllFile: function() {

        var output = [];
        const path = require("path");
        //读取文件的路径 是否遍历文件的子目录 匹配文件正则表达式
        const files = require.context("../../lib/images");
        files.keys().forEach(key => {
            //key 是一个文件的目录路径
            //遍历所有文件的目录路径 然后进行字符串分割 ['','../','png']
            var outArray = key.split(".", 10)[1].split("/", "99");
            this.deepDiretory(output, outArray, 1, key.split(".", 10)[2]);
        });
        return output;

    },
    //递归判断是否里面有这个玩意 如果他不是最深一层的 即往里面寻找并且为其创建

    //array 为要返回的原始列表，MsgArray为传入的
    deepDiretory: function(array, msgArray, index, type) {
        var inThisFoolr = false;
        var floortemp = {};
        //遍历判断是否为同一层 index为所在层数
        array.forEach(element => {
            if (element.name == msgArray[index]) {
                //说明这一层相同
                inThisFoolr = true;
                floortemp = element;
            } else {}
        });

        //通过判断inThisFoolr来判断是否在这一层有
        if (inThisFoolr) {
            //若是这一层 有了这数据列表相对应的 数据 那么遍历里面的内容 即往下一层 看他的孩子 是否在 这个数据的下一层
            //此时floortemp 为element的缓存 即他的孩子节点为 下一层的array index应该加一
            this.deepDiretory(floortemp.children, msgArray, index + 1, type);

        } else {
            //不存在则往里创建一个
            var DiretoryFoor = {}
                //如果是图片则不给它创建孩子列表
            if (msgArray.length == index + 1) {
                if (type) {
                    DiretoryFoor = {
                        value: msgArray[index],
                        name: msgArray[index],
                        type: type,
                        label: msgArray[index]
                    }
                    array.push(DiretoryFoor);
                } else {
                    DiretoryFoor = {
                        value: msgArray[index],
                        name: msgArray[index],
                        label: msgArray[index]
                    }
                    array.push(DiretoryFoor);
                }
            } else {
                // 否则给它创建孩子列表
                DiretoryFoor = {
                    value: msgArray[index],
                    name: msgArray[index],
                    label: msgArray[index],
                    children: []
                }
                array.push(DiretoryFoor);
                this.deepDiretory(array, msgArray, index, type);
            }
        }
    }
}