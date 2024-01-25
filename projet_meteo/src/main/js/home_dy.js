function openForm() {
    document.getElementById("popupForm").style.display = "block";
}

function closeForm() {
    document.getElementById("popupForm").style.display = "none";
}

var markersData = [
                    {lat: 48.8566, lng: 2.3522, title: 'Paris'},
                    {lat: 51.5074, lng: -0.1278, title: 'Londres'},
                    // Ajoutez d'autres données de marqueurs ici
    ];

let map;
// initMap is now async
async function initMap() {
    // Request libraries when needed, not in the script tag.
    const { Map } = await google.maps.importLibrary("maps");
    // Short namespaces can be used.
    map = new Map(document.getElementById("map"), {
        center: { lat: 48.8566, lng: 2.3522 },
        zoom: 6.66,
    });


    for (var i = 0; i < markersData.length; i++) {
                var marker = new google.maps.Marker({
                    position: {lat: markersData[i].lat, lng: markersData[i].lng},
                    map: map,
                    title: markersData[i].title
                });
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
    }
});

