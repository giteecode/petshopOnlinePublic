const base = {
    get() {
        return {
            url : "http://localhost:8080/wangshangchongwudian/",
            name: "wangshangchongwudian",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/wangshangchongwudian/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "网上宠物店系统"
        } 
    }
}
export default base
