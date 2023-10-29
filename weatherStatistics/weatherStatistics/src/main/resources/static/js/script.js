
// To fetch the Home page HTML
document.addEventListener("DOMContentLoaded", async function () {

        let data;
        try {
             const response = await fetch("/");
             console.log(response)
             if (!response.ok) {
                  data = await response.json();
                  console.log(data);
                  throw new Error(data.message);
             }else{
              data = await response.text(); // Parse the response body as JSON
              let container = document.getElementById("container");
              if(container == null){
                   throw new Error("The Route Not Exists");
              }else{
                  container.textContent = data;
              }
                 }
            } catch (error) {
                document.getElementById("errorMessage").innerHTML = error;// In the error.html
                   }
});

