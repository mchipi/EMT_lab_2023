import axios from "../custom-axios/axios";

const BooksService = {
    fetchBooks: () => {
        return axios.get("/books");
    },
    deleteBook: (id) => {
        return axios.delete(`/books/delete/${id}`);
    },
    addBook: (name, category, authorId, availableCopies) => {
        return axios.post("/books/add",{
            "name":name,
            "category": category,
            "authorId": authorId,
            "availableCopies": availableCopies
        })

    },
    fetchCategories: () =>{
        return axios.get("/books/categories");
    },
    fetchAuthors: () =>{
        return axios.get("/authors");
    },
    fetchBook: (id) =>{
        return axios.get(`/books/${id}`)
    },
    editBook: (id, name, category, authorId, availableCopies) =>{
        return axios.put(`/books/edit/${id}`,{
            "name" : name,
            "category": category,
            "authorId": authorId,
            "availableCopies": availableCopies
        })
    },
    rentBook: (id) => {
        return axios.get(`/books/${id}/rent`)
    }
}

export default BooksService;