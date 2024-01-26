function openForm() {
    document.getElementById("popupForm").style.display = "block";
}

function closeForm() {
    document.getElementById("popupForm").style.display = "none";
}

var markersData = [
              {
                    lat: 48.8566,
                     lng: 2.3522,
                      title: 'Paris',
                       temperature: [12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23],
                        windSpeed:  [5 , 10, 15, 20, 25, 30, 5 , 10, 15, 20, 25, 30, 5 , 10, 15, 20, 25, 30, 5 , 10, 15, 20, 25, 30],
                         humidity:  [65, 70, 75, 80, 85, 90, 65, 70, 75, 80, 85, 90, 65, 70, 75, 80, 85, 90, 65, 70, 75, 80, 85, 90]
              },
             {lat: 51.5074,
              lng: -0.1278,
               title: 'Londres',
                temperature: [10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21],
                 windSpeed:  [5 , 10, 15, 20, 25, 30, 5 , 10, 15, 20, 25, 30, 5 , 10, 15, 20, 25, 30, 5 , 10, 15, 20, 25, 30],
                  humidity:  [65, 70, 75, 80, 85, 90, 65, 70, 75, 80, 85, 90, 65, 70, 75, 80, 85, 90, 65, 70, 75, 80, 85, 90]
              },
                    // Ajoutez d'autres données de marqueurs ici
    ];

let map;

    
    function showWeatherInfo(marker, data) {
        var contentString = `
            <h3>${data.title}</h3>
            <div id="content" style="width: 300px; height: 150px;">
                <div style="float: left; width: 50px;">
                    <img src="soleil.png" alt="Soleil" style="width: 50px; height: 50px;">
                </div>
                <div style="float: left; width: 200px;">
                    <canvas id="weatherChart" width="200" height="150"></canvas>
                </div>
                <div style="float: left; width: 50px;">
                    <p>Temp: ${data.temperature}°C</p>
                    <p>Wind: ${data.windSpeed} km/h</p>
                    <p>Humidity: ${data.humidity}%</p>
                </div>
            </div>
        `

        var infowindow = new google.maps.InfoWindow({
            content: contentString
        });

        infowindow.open(map, marker);

        infowindow.addListener('domready', function() {
                var ctx = document.getElementById('weatherChart').getContext('2d');
                if (window.weatherChart instanceof Chart) {
                    window.weatherChart.destroy();
                }
                var weatherChart = new Chart(ctx, {
                    type: 'bar',
                    data: {
                        labels: ['00h', '01h', '02h', '03h', '04h', '05h', '06h', '07h', '08h', '09h', '10h', '11h', '12h',
                        '13h', '14h', '15h', '16h', '17h', '18h', '19h', '20h', '21h', '22h', '23h', ], // Les heures devraient correspondre à vos données
                        datasets: [{
                            label: 'Température',
                            data: data.temperature,
                            backgroundColor: 'rgba(255, 206, 86, 0.2)',
                            borderColor: 'rgba(255, 206, 86, 1)',
                            borderWidth: 1
                        },
                        {
                            label: 'Vitesse du vent (km/h)',
                            data: data.windSpeed,
                            backgroundColor: 'rgba(54, 162, 235, 0.2)',
                            borderColor: 'rgba(54, 162, 235, 1)',
                            borderWidth: 1
                        },
                        {
                            label: 'Humidité (%)',
                            data: data.humidity,
                            backgroundColor: 'rgba(75, 192, 192, 0.2)',
                            borderColor: 'rgba(75, 192, 192, 1)',
                            borderWidth: 1
                        }]
                    },
                    options: {
                        scales: {
                            y: {
                                beginAtZero: true
                            }
                        },
                        responsive: true,
                        maintainAspectRatio: false
                    }
                });
            });
    }



async function initMap() {
    // Request libraries when needed, not in the script tag.
    const { Map } = await google.maps.importLibrary("maps");
    // Short namespaces can be used.
    map = new Map(document.getElementById("map"), {
        center: { lat: 48.8566, lng: 2.3522 },
        zoom: 6.66,
    });


    for (let i = 0; i < markersData.length; i++) {
            let marker = new google.maps.Marker({
                position: {lat: markersData[i].lat, lng: markersData[i].lng},
                map: map,
                title: markersData[i].title
            });

            // Utilisez une fonction immédiatement invoquée pour capturer la valeur actuelle de `i`
            (function(currentMarker, currentData) {
                currentMarker.addListener('click', function() {
                    showWeatherInfo(currentMarker, currentData);
                });
            })(marker, markersData[i]); // Passez le marqueur et les données actuelles à la fonction
        }
}




initMap()
document.addEventListener('DOMContentLoaded', function() {
    var tableBody = document.getElementById('table-body');

    // Boucle pour ajouter des lignes au tableau
    for (var i = 0; i < markersData.length; i++) {
        var rowData = markersData[i];

        // Créez une nouvelle ligne pour le tableau
        var newRow = tableBody.insertRow();

        // Ajoutez des cellules à la ligne avec les données correspondantes
        var cell1 = newRow.insertCell(0);
        cell1.innerHTML = rowData.lat; // Supposons que lat soit la propriété de latitude dans markersData

        var cell2 = newRow.insertCell(1);
        cell2.innerHTML = rowData.lng; // Supposons que lng soit la propriété de longitude dans markersData

        var cell3 = newRow.insertCell(2);
        cell3.innerHTML = rowData.title; // Supposons que title soit la propriété de titre dans markersData

         for (var j = 0; j < rowData.temperature.length; j++) {
                    var cellTemp = newRow.insertCell(3 + j); // Démarrez à partir de la 4ème colonne
                    cellTemp.innerHTML = rowData.temperature[j] + '°C';
         }

        var cellWindSpeed = newRow.insertCell(4);
        cellWindSpeed.innerHTML = rowData.windSpeed; // Vitesse du vent

        var cellHumidity = newRow.insertCell(5);
        cellHumidity.innerHTML = rowData.humidity; // Humidité
    }
});

