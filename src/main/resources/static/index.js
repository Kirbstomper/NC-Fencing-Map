// This example displays a marker at the center of Australia.
// When the user clicks the marker, an info window opens.
function initMap() {
    const NC = { lat:35.62593076963908, lng:-79.3111004143203};
    const map = new google.maps.Map(document.getElementById("map"), {
      zoom: 10,
      center: NC,
    });

    fetch('/api/getEvents')
    .then((response) => response.json())
    .then((data) => data.forEach(element => {
        console.log(element)

        //Create the string for use in the info box. FORMATTED
        var header = "<h1>" + element.eventName + "</h1>"
        var address ="<p>" + element.address + "</p>"
        var clubs = "<ul>"
        element.clubs.forEach(club => {
            clubs = clubs + "<li>" + club + "</li>"
        })
        clubs = clubs + "</ul>"
    
        var content_string = header + '\n' + address + "\n" + clubs
        
        const infowindow = new google.maps.InfoWindow({
            content: content_string,
            ariaLabel: "information",
          });

        const marker = new google.maps.Marker({
            position: element.location,
            map,
            title: element.eventName,
          });
        
          marker.addListener("click", () => {
            infowindow.open({
              anchor: marker,
              map,
            });
          });
    }));
  }
  
  window.initMap = initMap;