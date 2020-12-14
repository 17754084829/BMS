const $ = {
    //箭头函数，是es6的语法规则
    
    attr: (...arguments) => {
        if(arguments.length === 0)
        return;
        if(arguments.length === 2) {
           return arguments[0].getAttribute(arguments[1])
        } 
        if(arguments.length === 3) {
           return arguments[0].setAttribute(arguments[1], arguments[2]);
        }
    },
   
}
