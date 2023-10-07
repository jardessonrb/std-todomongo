// var requestOptions = {
//     method: 'POST', // Método da requisição
//     headers: {
//       'Content-Type': 'application/json'
//     },
//     body: JSON.stringify({ username: 'exemplo', password: 'senha123' })
//   };
  
//   fetch('https://api.example.com/data', requestOptions)
//     .then(function(response) {
//       if (response.ok) {
//         return response.json();
//       }
//       throw new Error('Erro na requisição.');
//     })
//     .then(function(data) {
//       console.log(data);
//     })
//     .catch(function(error) {
//       console.log(error);
//     });
  

function listenUpdateCheckbox(id){
    alert("mudou o valor do checkbox: "+id);
}