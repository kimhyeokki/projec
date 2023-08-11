const result = fetch(
  "https://apis.data.go.kr/1352000/ODMS_COVID_04/callCovid04Api?serviceKey=mZRGE%2BySu7j0ax6bx5VIzTyNc5DD0ZiPGdBE14KbyAhuTmi97eWkcvdm7GzIx4pNvHC5Alne5fdMeJq80ShhZw%3D%3D&pageNo=1&numOfRows=500&apiType=JSON&std_day=2023-08-07"
) //fetch
  .then(function (response) {
    //console.log(response);
    return response.json(); //premiss
  })
  .then(function (result) {
    //console.log(result);
    console.log(result.items[0].incDec);
    result.items.forEach(function (item, index) {
      console.log(item.gubun + ":" + item.incDec);
    });
  });
