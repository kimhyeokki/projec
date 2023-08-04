//js 컴파일 필요없음
//alert("hello javscript")
//console.log("hello javscript"); // 테스트하기 위해
const gnb = document.querySelector(".gnb > ul"); // gnb 클래스를 찾는다
const header = document.querySelector(".header");
const btnclose = document.querySelector(".popup .btns .close");

const popup = document.querySelector(".popup");

gnb.addEventListener("mouseenter", function () {
  console.log("gnb에 마우스 올라온걸 체크할 수 있다");
  header.classList.add("open");
}); // addevent라는 용어는 사용자의 작용에 의해서 나타내는 기능
gnb.addEventListener("mouseleave", function () {
  console.log("마우스가 gnb를 벗어나면 사라진다");
  header.classList.remove("open");
});
// console.log(gnb);
// btnclose.addEventListener("click", function () {
//   console.log("클릭하면 닫힌다");
//   popup.classList.add("hidden");
// });
