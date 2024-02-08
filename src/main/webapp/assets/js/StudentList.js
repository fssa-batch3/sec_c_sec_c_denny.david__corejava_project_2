let editButton = document.querySelectorAll(".editButton");

let edit = document.getElementById("editstupopup");
 edit.style.display = "none";
 editButton.forEach(e=>{
	 e.onclick =function(){
	edit.style.display = "block";
	
}
 })

const url = window.location.search; // ?name=Arun
const urlParams = new URLSearchParams(url); // converting string into key value pair
const view = urlParams.get("view");

console.log(view);

if(view.trim() === "class"){

    const baseUrl = window.location.protocol + '//' + window.location.host + '/';
    const contextPath = window.location.pathname.split('/')[1]; // Extract the context path

    const fullUrl = baseUrl + contextPath;

    let getMoveBtn = document.getElementById("moveBtn");
    let getOptions = document.getElementById("updateClassId");

    getMoveBtn.style.display="none";
    getOptions.style.display="none";

    let ids;

    let getMove = document.querySelectorAll(".moveBtns");

    getMove.forEach((e)=>{

        e.addEventListener('click', ()=>{

           ids = Array.from(getMove) // Convert checkboxes to an array to use filter and map.
                .filter((i) => i.checked) // Use Array.filter to remove unchecked checkboxes.
                .map((i) => i.value);

            if(ids.length != 0){

                getMoveBtn.style.display="";
                getOptions.style.display="";
            }else {

                getMoveBtn.style.display="none";
                getOptions.style.display="none";

            }
        });
    });

    getMoveBtn.addEventListener('click', ()=>{

        let str = "";

        if(ids.length == 0){

            str = ids[0] + ",";
        }else {

            for(let i=0; i < ids.length; i++){

                str+=ids[i]+",";
            }
        }

        // console.log(fullUrl + "/UpdateStudentClass?ids=" + str + "&class=" + getOptions.value);

        window.location.href = fullUrl + "/UpdateStudentClass?ids=" + str + "&class=" + getOptions.value;
    })

}
