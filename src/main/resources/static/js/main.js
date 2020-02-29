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

async function addToBasket(id){
    try{
        await axios.post(`api/basket/add-to-basket/${id}`)
        getBasket();
    }catch(err){
        console.log(err)
    }
}

async function getBasket(){
    try{
        const res = await axios.get('/api/basket/get-basket')
        let items = res.data.reservedProducts
        displayBasket(items)
    }catch(err){
        console.log(err)
    }
}

function displayBasket(items){
        let templateCart
        items.forEach(item => {
            templateCart += `
                <li class="list-group-item">Quantity: ${item.quantity} | Price: ${item.price}</li>
            `
            cart.innerHTML = templateCart
        })

}

window.addEventListener('DOMContentLoaded', () => {
    getProducts().then(books => displayProducts(books));
});