/**
 * art-template에서 제공하는 Filter기능을 사용하기 위한 모듈
 * runtime 객체를 만들고, 해당객체에 함수를 추가하는 형태로 사용하게끔 되어 있지만
 * 각 스크립트에서 이러한 처리를 추가하는 것이 아니라 이 모듈에 Filter에서 사용할 모든 함수를 추가하는 함수를 선언해두고
 * Filters모듈을 사용해 필요한 필터함수를 추가해 사용하는 식으로 구현(chaining)
 * 
 * https://aui.github.io/art-template/docs/syntax.html#Filters   <-  공식문서
 */
export class Filters {

    constructor() {
        this.runtime = require('art-template/lib/runtime');
    }

    callFoo() {
        this.runtime.foo = FormatUtil.phone;
        return this;
    }

    callBar() {
        this.runtime.bar = function(param) {
            return param + "_bar";
        }
        return this;
    }

}


/* 외부에서 Filters모듈을 사용하는 방법 예시 */
new Filters()
    .callFoo()
    .callBar();
