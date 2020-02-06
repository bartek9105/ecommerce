let book = [];
const container = document.querySelector(".card-group");

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
                    <a href="#" class="btn btn-primary">Add to basket</a>
                </div>
            </div>
        `
        container.insertAdjacentHTML("beforeend", template);
    })

}

window.addEventListener('DOMContentLoaded', () => {
    getProducts().then(books => displayProducts(books));
});