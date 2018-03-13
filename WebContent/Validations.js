			function confirmvalidatePassword(){
				if(document.getElementById("Password").value != document.getElementById("confirmPassword").value){
					document.getElementById("msg").style.color='red';
					document.getElementById("msg").textContent="Not Matching";
					document.getElementById("submit").disabled=true;
				}
				else{
					document.getElementById("msg").innerHTML='';
					document.getElementById("submit").disabled=false;
				}
			}
			
			function validatePassword(){
				if(! (document.getElementById("Password").value).match(/^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$/)){
					document.getElementById("msg1").style.color='red';
					document.getElementById("msg1").textContent="Password must be minimum eight characters, at least one letter and one number:";
					document.getElementById("submit").disabled=true;
				}
				else{
					document.getElementById("msg1").innerHTML='';
					document.getElementById("submit").disabled=false;
				}
			}
			function validateMobile(){
				if(! (document.getElementById("contactNumber").value).match(/^[789]\d{9}$/)){
					document.getElementById("contactMessage").style.color='red';
					document.getElementById("contactMessage").textContent="Invalid Mobile Number";
					document.getElementById("submit").disabled=true;
				}
				else{
					document.getElementById("contactMessage").innerHTML='';
					document.getElementById("submit").disabled=false;
				}

			}
			
			function validateFName(){
				if(! (document.getElementById("firstName").value).match(/^[a-zA-Z]*$/)){
					document.getElementById("fname").style.color='red';
					document.getElementById("fname").textContent="name must only contain characters";
					document.getElementById("submit").disabled=true;
				}
				else{
					document.getElementById("fname").innerHTML='';
					document.getElementById("submit").disabled=false;
				}

			}
			
			function validateLName(){
				if(! (document.getElementById("lastName").value).match(/^[a-zA-Z]*$/)){
					document.getElementById("lname").style.color='red';
					document.getElementById("lname").textContent="name must only contain characters";
					document.getElementById("submit").disabled=true;
				}
				else{
					document.getElementById("lname").innerHTML='';
					document.getElementById("submit").disabled=false;
				}

			}
			
			
			function validateDate(){
				var selectedDate= document.getElementById("Date").value;
				var selected = new Date(selectedDate);
				var currentdate = new Date();
				currentdate.setHours(0, 0, 0, 0);
				if( (selected < currentdate)){
					document.getElementById("date").style.color='red';
					document.getElementById("date").textContent="Date should be not be less than today's date";
					document.getElementById("submit").disabled=true;
				}
				else{
					document.getElementById("date").innerHTML='';
					document.getElementById("submit").disabled=false;
				}

			}
			

			
			
			
			