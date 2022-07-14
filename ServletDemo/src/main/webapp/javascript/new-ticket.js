// Getting our current user first

let user = localStorage.getItem('currentUser');

let userJSON = JSON.parse(user);

console.log(userJSON);

// Here we create another fetch function 

async function makeNewTicket(event){

    event.preventDefault();

    let ticketForm = document.getElementById("description");
    
    console.log(ticketForm);
    console.log(ticketForm.value);

    try {

        const raw_response = await fetch(`http://localhost:8080/ServletDemo/tickets`,

        {
        
            method: "POST", 

            headers: {
                "Content-Type":"application/json",
                "Access-Control-Allow-Origin":"*",
                "User-Id": userJSON.user_Id

            },

            body: JSON.stringify(ticketForm.value)



        }
        
        );

        if(!raw_response.ok){

            throw new Error(raw_response.status)
        }

        console.log("Request was completed")

        const json_data = await raw_response.json();

        console.log(json_data);
            
            // Displays an alert saying Ticket# has been created
        alert(` Ticket #: ${json_data} - Has been created`)


        // setTimeout (this method executes delay) takes an anonymous function
        setTimeout(() => {

                // This logic will redirect the user to tickets.html page
            window.location.replace('tickets.html');

            // 1000 indicates how long before appearing
        }, 1000)

    } catch (error) {




    }


}