//배열 (나열)
///
//["ㅇㄴㅁㅇ", "ㅁㄴㅇㄷㄷ", 'ㄷㄹㄷ']
let myCalss = ["ㅇㄴㅁㅇ", "ㅁㄴㅇㄷㄷ", "ㄷㄹㄷ"]; //규칙을 만드는
console.log(myCalss[0]);
console.log(myCalss[1]);
console.log(myCalss[2]);
const current = new Date(); //new Date() 날짜를 가르키는 함수
console.log(current);
const yoil = current.getDay();
console.log(current.getDay());

const yoilArray = ["일", "월", "화", "수", "목", "금", "토"];
yoilArray.push("첨으로"); //배열 뒤에 추가됨,, unshift 앞에 추가
console.log(yoilArray[yoil]);

const num = 110 + 4;
let i = 0;
i = i + 1; //=  i += 1;

for (let i = 0; i < 8; i++) {
  console.log(yoilArray[i]);
}

// 배열 복사하는 법
let animal01 = ["cat", "puppy", "bear", "lion"];
//let num02 = num01   // 얕은 복사
let copyanimals01 = [...animal01]; //다른 복사가 된다
//                = [...animal01, "dog"]
copyanimals01.push("dog");

for (let i = 0; i < animal01.length; i++) {
  console.log(animal01[i]);
}
animal01.forEach(function (item, idex) {
  //item은 요소, idex 순서, idex는 생략가능
  console.log(idex, ":", item);
  console.log(item);
});
// 배열 메스트에 반복문이 있다. iteration : 반복

console.log(...animal01); //... 은 스프레드 흩뿌리다
console.log(...copyanimals01);
