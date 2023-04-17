import React from "react";
import {useNavigate} from "react-router-dom";

// name, category, authorId, availableCopies

function EditBook (props) {

    const navigate = useNavigate();
    const [formData, updateFormData] = React.useState({
        name: "",
        category: "",
        authorId: 0,
        availableCopies: 0
    })

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        })
        console.log(e.target.value)
    }

    const onFormSubmit = (e) => {
        e.preventDefault();
        const name = formData.name !== "" ? formData.name : props.book.name;
        const category = formData.category !== "" ? formData.category : props.book.category;
        const authorId = formData.authorId !== 0 ? formData.authorId : props.book.author.id;
        const availableCopies = formData.availableCopies !== 0 ? formData.availableCopies : props.book.availableCopies;

        props.onEditBook(props.book.id, name, category, authorId, availableCopies)
        console.log(props.book.author.id);
        navigate('/books');
    }

    return(
        <div className="row mt-5">
            <div className="col-md-5">
                <form onSubmit={onFormSubmit} noValidate>
                    <div className="form-group">
                        <label htmlFor="name">Title</label>
                        <input type="text"
                               className="form-control"
                               id="name"
                               name="name"
                               required
                               placeholder={props.book.name}
                               onChange={handleChange}
                        />
                    </div>

                    <div className="form-group">
                        <label htmlFor="availableCopies">Available Copies</label>
                        <input type="text"
                               className="form-control"
                               id="availableCopies"
                               name="availableCopies"
                               placeholder={props.book.availableCopies}
                               required
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label>Category</label>
                        <select name="category" className="form-control" onChange={handleChange}>
                            {/*<option selected>Select category</option>*/}
                            {props.categories.map((term) => {
                                    // <option value={term}>{term}</option>
                                    if (props.book.category !== undefined &&
                                        props.book.category === term)
                                        return <option selected={props.book.category}
                                                       value={term}>{term}</option>
                                    else return <option value={term}>{term}</option>
                                }
                            )}
                        </select>
                    </div>
                    <div className="form-group">
                        <label>Author</label>
                        <select name="authorId" className="form-control" onChange={handleChange}>
                            {/*<option selected>Select author</option>*/}
                            {props.authors.map((term) => {
                                    if(props.book.author !== undefined &&
                                        props.book.author.id === term.id)
                                        return <option selected
                                                       value={props.book.author.id}>{term.name}</option>
                                    else return <option value={term.id}>{term.name}</option>
                            }
                            )}
                        </select>
                    </div>
                    <button id="submit" type="submit" className="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    )
}

export default EditBook;