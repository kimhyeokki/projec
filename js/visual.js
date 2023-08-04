const swiper = new Swiper(".main-visual", {
  effect: "slide",
  loop: "true",
  autoplay: {
    delay: 3000,
  },
  speed: 1000,
  pagination: {
    el: ".main-visual .pagination", //el 안에 함수 위치를 지정해야함
    type: "bullets",
    clickable: "true",
  },
});
