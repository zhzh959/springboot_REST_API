showHeader();

function showHeader() {
    fetch('http://localhost:8080/api/user')
        .then(response => response.json())
        .then(user => {

            //заполняем статусбар
            document.getElementById("header_login").innerHTML = user.login;

            let rolesList = document.createElement('ul');
            for (let i = 0; i < user.roles.length; i++) {
                let role = document.createElement('li');
                role.textContent = user.roles[i].roleName + " ";
                rolesList.appendChild(role);
            }
            document.getElementById("header_roles").innerHTML = 'with roles: ' + rolesList.textContent;
        });
}