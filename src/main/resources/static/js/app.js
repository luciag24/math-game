document.addEventListener('DOMContentLoaded', () => {
    console.log('Načítavam elementy...');
    
    const resultMessage = document.getElementById('resultMessage');
    const userAnswer = document.getElementById('answer');
    const generateExampleButton = document.getElementById('generateExampleButton');
    const stopButton = document.getElementById('stopButton');
    const gradeSelect = document.getElementById('grade');
    const nextButton = document.getElementById('next');
    const exampleText = document.getElementById('exampleText');
    
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
    
    // Globální proměnná pro uchování aktuálního příkladu
    let currentExample = null;
    
    // Generování nového příkladu
    generateExampleButton.addEventListener('click', () => {
        const grade = gradeSelect.value;
        console.log("Kliknutie na tlačidlo, ročník:", grade);
        
        // Zavolaj backend na generovanie nového príkladu
        fetch(`/api/generate?grade=${grade}`)
            .then(response => {
                if (!response.ok) {
                    throw new Error('Chyba při načítání příkladu: ' + response.status);
                }
                return response.json();
            })
            .then(data => {
                // Uložení aktuálního příkladu
                currentExample = data;
                console.log("Přijatá data:", data);
                
                // Zobraz nový příklad
                exampleText.innerText = data.question;
                userAnswer.value = '';
                resultMessage.innerText = '';
            })
            .catch(error => console.error('Chyba pri načítaní príkladu:', error));
    });
    
    // Kontrola odpovědi
    nextButton.addEventListener('click', () => {
        const answer = userAnswer.value;
        
        if (!currentExample) {
            resultMessage.innerText = 'Nejprve vygenerujte příklad!';
            return;
        }
        
        if (answer) {
            // Výpis pro debugging
            console.log("Aktuální příklad:", currentExample);
            console.log("Očekávaná odpověď:", currentExample.correctAnswer);
            console.log("Uživatelská odpověď:", answer);
            
            // Vytvoření objektu pro odeslání
            const requestData = {
                id: currentExample.id,
                question: currentExample.question,
                correctAnswer: currentExample.correctAnswer,
                userAnswer: parseInt(answer)
            };
            
            console.log("Odesílaná data:", requestData);
            
            fetch('/api/check-answer', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(requestData)
            })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Chyba při kontrole odpovědi: ' + response.status);
                }
                return response.json();
            })
            .then(result => {
                console.log("Odpověď ze serveru:", result);
                
                // Použití isCorrect nebo correct, podle toho co server vrátí
                if (result.correct === true || result.isCorrect === true) {
                    resultMessage.innerText = 'Správna odpoveď!';
                    resultMessage.style.color = '#28a745';
                    // Automaticky generovat nový příklad po správné odpovědi
                    setTimeout(() => generateExampleButton.click(), 1500);
                } else {
                    resultMessage.innerText = 'Nesprávne, skúste znova!';
                    resultMessage.style.color = '#dc3545';
                }
            })
            .catch(error => console.error('Chyba pri overovaní odpovede:', error));
        } else {
            resultMessage.innerText = 'Zadajte odpoveď pred kontrolou!';
        }
    });
    
    // Ukončení hry a zobrazení statistiky
    stopButton.addEventListener('click', () => {
        fetch('/api/progress')
            .then(response => {
                if (!response.ok) {
                    throw new Error('Chyba při načítání statistiky: ' + response.status);
                }
                return response.text();
            })
            .then(data => {
                resultMessage.innerText = data;
                exampleText.innerText = '';
            })
            .catch(error => console.error('Chyba pri načítaní štatistiky:', error));
    });
    
    // Inicializační volání pro generování prvního příkladu
    generateExampleButton.click();
});