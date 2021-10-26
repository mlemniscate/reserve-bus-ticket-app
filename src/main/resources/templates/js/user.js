function loadUser() {
  const xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {
      let user = JSON.parse(this.responseText);
      document.getElementById('userFirstLastName').innerHTML =
        user.firstName + ' ' + user.lastName;
    }
  };
  xhttp.open(
    'GET',
    `http://localhost:8080/user/user?username=${sessionStorage.getItem(
      'username'
    )}`
  );
  xhttp.send();
}
loadUser();

document.querySelector('#logout').addEventListener('click', (event) => {
  if (confirm('آیا می خواهید از حساب خود خارج شوید؟')) {
    sessionStorage.clear();
    window.location.href = 'index.html';
  }
});

// date picker
let dateInput = document.getElementById('date');
jalaliDatepicker.startWatch();
dateInput.addEventListener('focus', (event) => {
  jalaliDatepicker.show(dateInput);
});

// search result
let date = document.querySelector('#date');
let destination = document.querySelector('#destination');
let initial = document.querySelector('#initial');
let searchBox = document.querySelector('#search-result-box');
let travelsData;

function searchTravels() {
  const xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {
      travelsData = JSON.parse(this.responseText);
      searchBox.innerHTML = '';
      for (let i = 0; i < travelsData.length; i++) {
        const element = travelsData[i];
        let sample = `<div class="card mt-3" style="width: 20rem">
          <div class="card-body text-center">
            <h5 class="card-title">
              ${element.initial} <i class="bi bi-arrow-left"></i> ${element.destination}
            </h5>
            <p class="card-text">
              تاریخ حرکت <i class="bi bi-arrow-left"></i> ${element.date} <br />
              ساعت حرکت <i class="bi bi-arrow-left"></i> ${element.time} <br />
              شناسه بلیط <i class="bi bi-arrow-left"></i> ${element.id}
            </p>
            <a onclick="buyTicket(${element.id})" href="#" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">خرید</a>
          </div>
        </div>`;
        searchBox.innerHTML += sample;
      }
    }
  };
  xhttp.open(
    'GET',
    `http://localhost:8080/travel/search?initial=${initial.value}&destination=${destination.value}&date=${date.value}`
  );
  xhttp.send();
}

document.querySelector('#search').addEventListener('click', (event) => {
  if (date.value != '' && destination.value != '' && initial.value != '') {
    searchTravels();
  } else {
    alert('تمامی فیلدها را پر کنید!');
  }
});

// buy ticket
function buyTicket(id) {
  sessionStorage.setItem('travel_id', id);
}

function buyTicketAccept() {
  let input = document.querySelector('#ownerName');
  if (input.value != '') {
    let travelId = sessionStorage.getItem('travel_id');
    let username = sessionStorage.getItem('username');
    let ownerName = input.value;
    let gender = document.querySelector('input[name="gender"]:checked').value;
    let data = `{
        "travelId": "${travelId}",
        "username": "${username}",
        "ownerName": "${ownerName}",
        "gender": "${gender}"
      }`;
    saveBuyTicket(data);
    sessionStorage.setItem('travelId', travelId);
    sessionStorage.setItem('ownerName', ownerName);
    sessionStorage.setItem('gender', gender);
    window.location.href = 'successTicketBuy.html';
  } else {
    alert('تمامی فیلدها را پر کنید!');
  }
}

function saveBuyTicket(data) {
  var url = 'http://localhost:8080/user/buy-ticket';
  var xhr = new XMLHttpRequest();
  xhr.open('POST', url);
  xhr.setRequestHeader('Accept', 'application/json');
  xhr.setRequestHeader('Content-Type', 'application/json');
  xhr.send(data);
}

// Show tickets
document.querySelector('#showTickets').addEventListener('click', (event) => {
  searchTickets();
});

let userTickets;
function searchTickets() {
  const xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {
      userTickets = JSON.parse(this.responseText);
      searchBox.innerHTML = '';
      for (let i = 0; i < userTickets.length; i++) {
        const element = userTickets[i];
        let sample = `<div class="card mt-3" style="width: 20rem">
          <div class="card-body text-center">
            <h5 class="card-title">
              بلیط
            </h5>
            <p class="card-text">
              تاریخ <i class="bi bi-arrow-left"></i> ${element.date} <br />
              شناسه بلیط <i class="bi bi-arrow-left"></i> ${element.ticketId}
            </p>
            <a onclick="showTicket(${i})" href="#" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalTicket">مشاهده بلیط</a>
          </div>
        </div>`;
        searchBox.innerHTML += sample;
      }
    }
  };
  xhttp.open(
    'GET',
    `http://localhost:8080/ticket/user-tickets?username=${sessionStorage.getItem(
      'username'
    )}`
  );
  xhttp.send();
}

function showTicket(ticketIndex) {
  sessionStorage.setItem('ticketIndex', ticketIndex);
  document.querySelector(
    '#modalShowTicket'
  ).innerHTML = `<div class="text-center">
  <h5 class="card-title">
    ${userTickets[ticketIndex].initial} <i class="bi bi-arrow-left"></i> ${userTickets[ticketIndex].destination}
  </h5>
  <p class="card-text">
    شناسه بلیط <i class="bi bi-arrow-left"></i> ${userTickets[ticketIndex].ticketId} <br />
    نام <i class="bi bi-arrow-left"></i> ${userTickets[ticketIndex].name} <br />
    جنسیت <i class="bi bi-arrow-left"></i> ${userTickets[ticketIndex].gender} <br />
    تاریخ حرکت <i class="bi bi-arrow-left"></i> ${userTickets[ticketIndex].date} <br />
    ساعت حرکت <i class="bi bi-arrow-left"></i> ${userTickets[ticketIndex].time} <br />
    شناسه سفر <i class="bi bi-arrow-left"></i> ${userTickets[ticketIndex].travelId} <br />
  </p>
</div>`;
}

// Delete Ticket
function deleteTicket() {
  let ticketIndex = sessionStorage.getItem('ticketIndex');
  if (confirm('آیا از لغو بلیط مطمئن هستید؟')) {
    let ticketId = userTickets[ticketIndex].ticketId;
    var url = `http://localhost:8080/ticket/remove?id=${ticketId}`;
    var xhr = new XMLHttpRequest();
    xhr.open('GET', url);
    xhr.send();
  }
}
