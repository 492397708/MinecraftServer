package module.common.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Dragon丿Z
 * @desc 请求参数头部信息
 * @date : 2022/09/09 14:20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Header {
    /**
     * 请求内容
     */
    private String content;
}
