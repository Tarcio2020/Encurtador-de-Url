document.getElementById('shortenBtn').addEventListener('click', function() {
    const urlInput = document.getElementById('urlInput').value;
    fetch('/api/shorten', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ url: urlInput }),
    })
    .then(response => response.json())
    .then(data => {
        const resultDiv = document.getElementById('result');
        if (data.shortUrl) {
            resultDiv.innerHTML = `URL encurtada: <a href="${data.shortUrl}" target="_blank">${data.shortUrl}</a>`;
            resultDiv.style.display = 'block';
        } else {
            resultDiv.innerHTML = 'Erro ao encurtar a URL.';
            resultDiv.style.display = 'block';
        }
    })
    .catch(error => {
        console.error('Erro:', error);
        const resultDiv = document.getElementById('result');
        resultDiv.innerHTML = 'Erro ao encurtar a URL.';
        resultDiv.style.display = 'block';
    });
});
