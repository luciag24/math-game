document.addEvenListener('DOMContentLoaded', () => {
console.log('Načítavam elementy...');

const resultMessage = document.getElementById('resultMessage');
const userAnswer = document.getElementById('userAnswer');
const generateExampleButton = document.getElementById('generateExampleButton');
const stopButton = document.get.ElementById('stopButton');
const gradeSelect = document.getElementById('grade');

console.log("resultMessage:", resultMessage);
console.log("userAnswer:", userAnswer);
console.log("generateExampleButton:", generateExampleButton);
console.log("stopButton:", stopButton);
console.log("gradeSelect:", gradeSelect);

if (!resultMessage) console.error("resultMessage chyba v HTML!");
if (!userAnswer) console.error("userAnswer chyba v HTML!");
if (!generateExampleButton) console.error("generateExampleButton chyba v HTML!");
if (!stopButton) console.error("stopButton chyba v HTML!");
if (!gradeSelect) console.error("gradeSelect chyba v HTML!");

//získaj hodnotu ročníka až pri kliknutí!
generateExampleButton.addEventListener('click', () => {
    const grade = gradeSelect.value;
    console.log("Kliknutie na tlačidlo, ročník:", grade);


    // Zavolaj backend na generovanie nového príkladu
    fetch(`/api/generate?grade=${grade}`)
        .then(response => response.json())
        .then(data => {
            // Zobraz nový príklad
            document.getElementById('exampleText').innerText = data.example;
            document.getElementById('userAnswer').value = '';
            document.getElementById('resultMessage').innerText = '';
        })
.catch(error => console.error('Chyba pri načítaní príkladu:', error));
});

document.getElementById('next').addEventListener('click', () => {
const answer = document.getElementById('userAnswer').value;

if (answer) {
    fetch('/api/check-answer', {
    method: 'POST',
    headers: {
    'Content-Type': 'application/json'
    },
    body: JSON.stringify({
        userAnswer: parseInt(answer)
    })
})
.then(response => response.json())
.then(result => {
    if (result.correct) {
        document.getElementById('resultMessage').innerText = 'Správna odpoveď!';
    } else {
        document.getElementById('resultMessage').innerText = 'Nesprávne, skúste znova!';
    }
})
    .catch(error => console.error('Chyba pri overovaní odpovede:', error));
  } else {
    document.getElementById('resultMessage').innerText = 'zadajte odpoveď pred kontrolou!';
    }
});

document.getElementById('stop').addEventListener('click', () => {
fetch('/progress')
.then(response => response.text())
.then(data => {
document.getElementById('resultMessage').innerText = data;
})
.catch(error => console.error('Chyba pri načítaní štatistiky:', error));
});




