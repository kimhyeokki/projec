console.log("hello js");
// var let const
// 변수
var num = 10;
var age = 22;

//var 변수의 유효범위 {}
// var의 변수는 유효 범위를 function 넘어간다 사용하지 않음
//let으로 대체, 중복선언 불가
{
  var name = 80;
  console.log(name);
}
console.log(name);

// for (var i = 0; i < 100; i++) {
//   console.log(i);
// }
let myname = "rrrr";
let myage = 1232;
myage = myage + 10;
let pi = 3.14;
console.log(myage === "1242"); //같다를 쓰기위해 ===3개를 사용, ==는 문자구별x
let isMarried = ""; //true, flase  ,1을 true로 0은 false
let myWeight = null; // null, "", Nan, 변수를 할당하지 않으면 flase로 생각함

let test = 0 / 0;
console.log(typeof isMarried);
if (isMarried) {
  console.log("결혼했음");
} else {
  console.log("미혼");
}
