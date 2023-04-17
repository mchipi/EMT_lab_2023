import React from "react";
import {Link} from "react-router-dom";

const bookTerm = (props) => {
    console.log()
    return(
        <tr>
            <td scope={"col"}>{props.term.name}</td>
            <td scope={"col"}>{props.term.category}</td>
            <td scope={"col"}>{props.term.author.name}</td>
            <td scope={"col"}>{props.term.availableCopies}
                <a title={"Delete"} className={"btn btn-danger"}
                   onClick={() => props.onDelete(props.term.id)}>
                    Delete
                </a>
                <Link className={"btn btn-info ml-2"}
                      onClick={() => props.onEdit(props.term.id)}
                      to={`/books/edit/${props.term.id}`} >
                    Edit
                </Link>
                <a title={"Rent"} className={"btn btn-danger"}
                   onClick={() => props.onRent(props.term.id)}>
                    Rent
                </a>
            </td>
        </tr>
    )
}

export default bookTerm;