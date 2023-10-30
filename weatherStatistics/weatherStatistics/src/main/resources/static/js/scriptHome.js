document.addEventListener("DOMContentLoaded", function () {

    // get the Form
    let form = document.getElementById("submitCity");
    // handle the submit
    form.addEventListener("submit", async function (event) {
        event.preventDefault();
        // get the city/country name
        let city = form.elements.inputCity.value;
        let data;
        try {
            const response = await fetch("weather/" + city);
            if (!response.ok) {
                data = await response.json();
                console.log(data);
                throw new Error(data.message);
            }else{
              data = await response.json(); // Parse the response body as JSON
              data = data.body;
              document.getElementById("country").textContent = "Country: "+data.location.country;
              document.getElementById("city").textContent = "City: "+data.location.name;
              document.getElementById("dateAPI").textContent = data.current.last_updated;
              document.getElementById("temperatureAPI").textContent = data.current.temp_c+" C - "+data.current.temp_f+" F";
              document.getElementById("conditionAPI").textContent = data.current.condition.text;
              //1
              let divForecast = document.getElementById('forecast');
              divForecast.innerHTML = "";
              data.forecast.forecastday.forEach(function (element,i) {
                          //2
                          let div2 = document.createElement('div');
                          div2.classList.add('col-sm-4' , 'col-xs-12');
                          divForecast.appendChild(div2);
                          //3
                          let div3 = document.createElement('div');
                          div3.classList.add('panel', 'panel-default', 'text-center');
                          div2.appendChild(div3);
                          //4
                          let div4 = document.createElement('div');
                          div4.classList.add('panel-heading');
                          div3.appendChild(div4);
                          // h1 in div4
                          let h1Date = document.createElement('h1');
                          h1Date.innerHTML = element.date;
                          div4.appendChild(h1Date);
                          //5
                          let div5 = document.createElement('div');
                          div5.classList.add('panel-body');
                          div3.appendChild(div5);
                          // Div 5 has 7 p
                          let p1MaxTempC = document.createElement('p');
                          p1MaxTempC.innerHTML = "max Temp C "+element.day.maxtemp_c;
                          div5.appendChild(p1MaxTempC);

                          let p2MaxTempF = document.createElement('p');
                          p2MaxTempF.innerHTML = "max Temp F "+element.day.maxtemp_f;
                          div5.appendChild(p2MaxTempF);

                          let p3MinTempC = document.createElement('p');
                          p3MinTempC.innerHTML = "min Temp C "+element.day.mintemp_c;
                          div5.appendChild(p3MinTempC);

                          let p4MinTempF = document.createElement('p');
                          p4MinTempF.innerHTML = "min Temp F "+element.day.mintemp_f;
                          div5.appendChild(p4MinTempF);

                          let p5AvgTempC = document.createElement('p');
                          p5AvgTempC.innerHTML = "Avg Temp C "+element.day.avgtemp_c;
                          div5.appendChild(p5AvgTempC);

                          let p6AvgTempF = document.createElement('p');
                          p6AvgTempF.innerHTML = "Avg Temp F "+element.day.avgtemp_f;
                          div5.appendChild(p6AvgTempF);

                          //6
                          let div6 = document.createElement('div');
                          div6.classList.add('panel-footer');
                          div3.appendChild(div6);
                          // h3 in 6
                          let h3 = document.createElement('h3');
                          h3.textContent = "Condition";
                          div6.appendChild(h3);
                          //h4 in 6
                          let h4Cond = document.createElement('h4');
                          h4Cond.textContent =element.day.condition.text;
                          div6.appendChild(h4Cond);
                        });
            }
        } catch (error) {
              openPopup();
              let pError = document.getElementById('errorMessage'); // In the Home.html
              pError.innerHTML = error;
        }
    });
});

//For popup
let popup = document.getElementById("popup");
function openPopup(){
    popup.classList.add("open-popup");
}
function closePopup(){
    popup.classList.remove("open-popup");
}
// For style
 $(document).ready(function(){
    // Add smooth scrolling to all links in navbar + footer link
    $(".navbar a, footer a[href='#myPage']").on('click', function(event) {
      // Make sure this.hash has a value before overriding default behavior
      if (this.hash !== "") {
        // Prevent default anchor click behavior
        event.preventDefault();

        // Store hash
        var hash = this.hash;

        // Using jQuery's animate() method to add smooth page scroll
        // The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area
        $('html, body').animate({
          scrollTop: $(hash).offset().top
        }, 900, function(){

          // Add hash (#) to URL when done scrolling (default click behavior)
          window.location.hash = hash;
        });
      } // End if
    });

    $(window).scroll(function() {
      $(".slideanim").each(function(){
        var pos = $(this).offset().top;

        var winTop = $(window).scrollTop();
          if (pos < winTop + 600) {
            $(this).addClass("slide");
          }
      });
    });
  })


