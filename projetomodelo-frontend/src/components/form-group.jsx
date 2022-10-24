export default function FormGroup(props) {

    return(
        <div className="form-group">
            <label htmlFor={props.htmlFor}>{props.label}</label>
            <div>
                {props.children}
            </div>

        </div>
        
    );
};

