let book = [];
const container = document.querySelector(".card-group");
const cart = document.querySelector(".list-group");

document.querySelector(".cart-icon").addEventListener('click', () => {
    cart.classList.toggle("toggle-display");
})

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
        let template = `
            <div class="card col-sm-4" style="width: 18rem;">
                <img src="${book.cover}" class="card-img-top" alt="cover">
                <div class="card-body">
                    <h3 class="card-title">${book.title}</h3>
                    <h4 class="card-title">${book.author}</h4>
                    <h5 class="card-title">${book.price} PLN</h5>
                    <a href="#" book-id="${book.bookId}" class="btn btn-primary" onclick="addToBasket(${book.bookId})">
                    Add to basket </a>
                </div>
            </div>
        `
        container.insertAdjacentHTML("beforeend", template);
    })
}

function addToBasket(id){
    axios.post('/api/basket/add-to-basket/${id}').then(res => console.log(res)).catch(err => console.log(err))
}

window.addEventListener('DOMContentLoaded', () => {
    getProducts().then(books => displayProducts(books));
});