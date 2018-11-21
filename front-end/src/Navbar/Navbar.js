import React from 'react';
import {
  Collapse,
  Navbar,
  NavbarToggler,
  NavbarBrand,
  Nav,
  NavItem, NavLink,} from 'reactstrap';
  // 
  // UncontrolledDropdown,
  // DropdownToggle,
  // DropdownMenu,
  // DropdownItem 
  import Search from '../SearchContainer/SearchContainer';
  //import Delete from '../DeleteUser/DeleteContainer';
  import App from '../App';
  import { Link } from 'react-router-dom'
import Profile from '../Profile';


  
class Navi extends React.Component {
  constructor(props) {
    super(props);

    this.toggle = this.toggle.bind(this);
    this.state = {
      isOpen: false
    };
  }
  toggle() {
    this.setState({
      isOpen: !this.state.isOpen
    });
  }
  render() {
    return (
      <div>
        <Navbar color="light" light expand="md">
          <NavbarBrand href="/">Sweater Weather</NavbarBrand>
          <NavbarToggler onClick={this.toggle} />
          <Collapse isOpen={this.state.isOpen} navbar>
            <Nav className="ml-auto" navbar>
              <NavItem>  
                {this.props.loggedIn ? <NavLink tag={Link} to="/" onClick={this.props.handleLogout}>Logout </NavLink> : <NavLink tag={Link} to='/login'>Login </NavLink> }
              </NavItem>
              <NavItem>
                  <NavLink tag={Link} to="/weather">Check the weather</NavLink>
              </NavItem>
              <NavItem>
                {this.props.loggedIn ? <NavLink tag={Link} to="/users/edit">Edit Profile</NavLink> : <div/>}
              </NavItem>
              <NavItem>
                <NavLink tag={Link} to="/user/delete" onClick={this.props.deletedUser.bind(null, this.props.id)}>Delete Yourself</NavLink>
              </NavItem>
              <NavItem>  
                <Search />            
              </NavItem>
            </Nav>
          </Collapse>
        </Navbar>
      </div>
    );
  }
}

export default Navi;