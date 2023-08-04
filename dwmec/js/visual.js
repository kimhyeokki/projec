//json
Splitting();
const swiper = new Swiper(".main-visual", {
  effect: "slide",
  loop: "true",
  autoplay: {
    deley: 3000,
    disableOnInteraction: "false",
  },
  speed: 1000,
  pagination: {
    el: ".main-visual .pagination", //el 안에 함수 위치를 지정해야함
    type: "bullets",
    clickable: "true",
  },
  navigation: {
    prevEl: " .main-visual .btn-prev",
    nextEl: " .main-visul .btn-next",
  },
  on: {
    slideChangeTransitionEnd: function () {
      console.log(this.realIndex);
      //console.log("swiper slideChangeTransitionEnd");
      gsap.to(".swiper-slide-active .char", {
        y: 0,
        opacity: 1,
        stagger: 0.05,
      });
    },
    slideChangeTransitionStart: function () {
      console.log(this.realIndex);
      //console.log("swiper slideChangeTransitionEnd");
      gsap.set(".swiper-slide-active .char", {
        y: -100,
        opacity: 0,
      });
    },
    init: function () {
      gsap.from(".swiper-slide-active .char", {
        y: -100,
        opacity: 1,
        stagger: 0.05,
      });
    },
  },
});
