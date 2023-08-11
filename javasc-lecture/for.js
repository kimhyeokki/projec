// 반복문
let i = 0;

while (i < 10) {
  console.log("실행된다");
  i++;
}
console.log("끝");

for (let i = 0; i < 10; i += 2) {
  console.log(i);
}
console.log(i);
// let j = 0;
// for (let j = 0; j < 100; j++) {
//   //3의 배수 만 빼기
//   if (j % 3 !== 0) {
//     // ! 부정 나눈게 0이 아니면

//     console.log(j);
//   } else {
//     continue; //제외한다
//   }
// }

//3의 배수의 합
let j = 0;
let num01 = 0;
for (let j = 0; j < 100; j++) {
  if (j % 3 === 0) {
    // ! 부정 나눈게 0이 아니면
    num01 = num01 + j;
  }
}
console.log(num01);

let t = 0;

for (let t = 0; t < 10; t++) {
  for (let y = 1; y < 10; y++) {
    console.log(`${t} x ${y} = ${y * t}`);
  }
}
