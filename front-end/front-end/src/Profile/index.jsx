import React, {Component} from "react";
import { Form, Label, Button } from "semantic-ui-react";

export default class Profile extends Component{
    render(){
        return(
            <div>
                <h1>Edit Your Profile</h1>
                <Form onSubmit={this.props.submitEdits}>
                    <Label>
                        username:
                        <Form.Input onChange={this.props.handleInputs} name="username" value={this.props.username}/>
                    </Label>
                    <Label>
                        password:
                        <Form.Input onChange={this.props.handleInputs} name="password" value={this.props.password}/>
                    </Label>
                    <Label>
                        location:
                        <Form.Input onChange={this.props.handleInputs} name="location" value={this.props.location}/>
                    </Label>
                    {/* <Form.Input type="hidden" name="id" value={this.props.id}/> */}
                    <br/>
                    <Button color="yellow" type="submit">Submit changes</Button>
                </Form>
            </div>
        )
    }
}