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
let searchButton = document.querySelector('#search-result-box');
let travelsData;

function searchTravels() {
  const xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {
      travelsData = JSON.parse(this.responseText);
      searchButton.innerHTML = '';
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
        searchButton.innerHTML += sample;
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

function buyTicket(id) {
  sessionStorage.setItem('travel_id', id);
}

function buyTicketAccept() {
  let input = document.querySelector('#fullName');
  if (input.value != '') {
    let travelId = sessionStorage.getItem('travel_id');
    let username = sessionStorage.getItem('username');
    let fullName = input.value;
    let gender = document.querySelector('input[name="gender"]:checked').value;
    console.log(travelId);
    console.log(username);
    console.log(fullName);
    console.log(gender);
  } else {
    alert('تمامی فیلدها را پر کنید!');
  }
}
