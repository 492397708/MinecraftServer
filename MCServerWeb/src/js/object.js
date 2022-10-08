class SysUser {
    constructor() {
        this.uuid = "";
        this.account = "";
        this.password = "";
        this.name = "";
    }
}


class BmCategory {
    constructor() {
        this.uuid = ""
        this.name = ""
        this.image = ""
        this.description = ""
    }
}

class BmType {
    constructor() {
        this.name = ""
        this.categoryUuid = ""
        this.content = ""
        this.icon = ""
    }
}



class BmItem {
    constructor() {
        this.categoryUuid = ""
        this.typeUuid = ""
        this.name = ""
        this.image = ""
    }
}


exports.SysUser = SysUser;
exports.BmCategory = BmCategory;
exports.BmType = BmType;
exports.BmItem = BmItem;