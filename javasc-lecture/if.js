if (3 !== 3) {
  console.log("조건이 참이면 출력");
} else {
  console.log("거짓일 때 출력");
}
// !는  부정의 의미
let score = 89;
if (score >= 90) {
  console.log("A");
} else if (score >= 80) {
  console.log("B");
} else if (score >= 70) {
  console.log("C");
} else if (score >= 60) {
  console.log("D");
} else {
  console.log("f");
}

let height = 180;
let Weight = 40;
let mheight = height / 100;
let result = Weight / (mheight * mheight); //mheight**2
console.log(result);
if (result >= 25) {
  console.log("비만");
} else if (result > 18.5) {
  console.log("정상");
} else {
  console.log("저체중");
}
