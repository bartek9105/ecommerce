const getProducts = () => {
    axios.get('/api/books/book/1').then(response => {
        console.log(response.data.title);
    }).catch(error => {
        console.log(error);
    });
}

console.log(getProducts());