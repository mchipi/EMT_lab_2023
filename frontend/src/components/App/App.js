import './App.css';
import {Component} from "react";
import React from "react";
import Books from "../Books/BooksList/books";
import BooksService from "../../repository/booksRepository";
import {BrowserRouter, Navigate, Route, Router, Routes} from "react-router-dom";
import Header from "../Header/header";
import Category from "../Category/category";
import AddBook from "../Books/AddBook/addBook";
import EditBook from "../Books/EditBook/editBook";

class App extends Component{

  constructor(props) {
    super(props);
    this.state = {
        books:[],
        categories:[],
        authors:[],
        selectedBook: {}
    }
  }

  render() {

    return(
        <BrowserRouter>
            <Header/>
            <main>
                    <Routes>
                        <Route path={"/books/categories"} element={<Category categories = {this.state.categories}/>} />
                        <Route path={"/books/edit/:id"} element={
                            <EditBook categories={this.state.categories}
                                         authors={this.state.authors}
                                         onEditBook={this.editBook}
                                         book={this.state.selectedBook}/>}/>
                        <Route path={"/books/add"} element={
                            <AddBook books = {this.state.books}
                                     authors={this.state.authors}
                                     categories = {this.state.categories}
                                     onAddBook={this.addBook}/>} />
                        <Route path={"/books"} element={
                            <Books books = {this.state.books}
                                   onDelete={this.deleteBook}
                                   onEdit={this.loadBook}
                                    onRent={this.rentBook}/>} />
                        <Route path={"/"} element={
                            <Books books = {this.state.books}
                                   onDelete={this.deleteBook}
                                   onEdit={this.loadBook}
                                   onRent={this.rentBook}/>} />
                        <Route path='*' element={<Navigate to='/' />} />
                    </Routes>
            </main>
        </BrowserRouter>
    )
  }

  loadBooks = () => {
    BooksService.fetchBooks()
        .then((data) => {
          this.setState({
            books: data.data
          })
        });
  }

  loadCategories = () => {
      BooksService.fetchCategories()
          .then((data) =>{
              this.setState({
                  categories: data.data
              })
          })
  }

  loadAuthors = () =>{
      BooksService.fetchAuthors()
          .then((data)=>{
              this.setState({
                  authors: data.data
              })
          })
  }

  loadBook = (id) => {
      BooksService.fetchBook(id)
          .then((data) =>{
              this.setState({
                  selectedBook: data.data
              })
          })
  }

  deleteBook =(id) =>{
      BooksService.deleteBook(id)
          .then(() => {
              this.loadBooks();
          })
  }

  addBook = (name, category, authorId, availableCopies) =>{
      BooksService.addBook(name, category, authorId, availableCopies)
          .then(() =>{
              this.loadBooks();
          })
  }

  editBook = (id, name, category, authorId, availableCopies) => {
      BooksService.editBook(id, name, category, authorId, availableCopies)
          .then(() => {
              this.loadBooks();
          })
  }

  rentBook = (id) => {
      BooksService.rentBook(id)
          .then(() => {
              this.loadBooks();
          })
  }



  fetchData = () => {
        this.loadBooks();
        this.loadCategories();
        this.loadAuthors();
    }

  componentDidMount() {
    this.fetchData();
  }

}

export default App;
