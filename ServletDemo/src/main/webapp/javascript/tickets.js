// http://localhost:8080/ServletDemo/user

// 1. Get your current user
// This is saying that user = will get the information saved to the currentUser

let user = localStorage.getItem('currentUser');

// We are going to parse our value to JSON
let userJSON = JSON.parse(user);
console.log(userJSON);

// Instead of using AJAX like we did when writing the login function on our index.html page

// We can use FETCH, which is more modern and versatile

/* We also use the 'async' and 'await' keyword with the 'fetch()' method. 
The 'async' keyword is added to functions to tell them to return a promise rather than directly returning the value. 
The 'await' keyword only works inside async functions, used to pause the code on that line until promise gets complete.
*/
getTickets();
async function getTickets(){

    try{

        // Here we will need to add the await keyword in order for us to be able to get response back
        // because the function can complete before the data we are requesting has come back to us

        const raw_response = await fetch (`http://localhost:8080/ServletDemo/tickets`,{
            
        // HTTP very

        method: "GET",
        headers: {
            "Content-Type": "application/json",
            "Access-Control-Allow-Origin": "*",
            "User-Id": userJSON.user_Id
        }

        // If this was a post request, this is where we would add our body

        }
        );

        // Check that we have received a successful response 

        if(!raw_response.ok){
            throw new Error(raw_response.status);
        }

        // Since this is an asynchronous function it will complete before we get a response back 
        // that is why we have to tell it to 'await'

        const json_data = await raw_response.json();

        // Log it 

        // Save this token into a session storage variable

        localStorage.setItem("tickets", JSON.stringify(json_data));
        console.log(localStorage.getItem("tickets"));

        // Here we are calling the function to render our html
        // which means here we will show the tickets we get back from our database
        // specific to this current user

        renderTickets(json_data);

    } catch(error){

        console.log(error);

    }

}

function renderTickets(ticketList){


    // Make a ref to the element on our HTML page

    let orderedList = document.getElementById("ticket-list");

    // Here we are going to iterate through the array that we should get back

    ticketList.array.forEach(element => {
        
        // Here we are creating a new list element for each element in our ticketList
        // aka the array we get back in our reponse (json_data)
        let item = document.createElement("li")
        item.innerText = `${element.ticket_Id} --- ${element.description} --- ${element.user_id}`

        orderedList.append(item);
        
    });
}