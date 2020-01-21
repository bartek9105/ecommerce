let book = [];
const list = document.querySelector('.list-group');
const listElement = document.createElement('li');
listElement.classList.add("list-group-item");

async function getProducts(){
    try{
        const response = await axios.get('/api/books/all');
        return response.data;
    } catch(error){
        console.log(error);
    }
}

function displayProducts(books){
    books.forEach(book => {
        let data = `Title: ${book.title}, Author: ${book.author}, Price: ${book.price}`;
        listElement.appendChild(document.createTextNode(data))
        list.appendChild(listElement);
    })

}

window.addEventListener('DOMContentLoaded', () => {
    getProducts().then(books => displayProducts(books));
});