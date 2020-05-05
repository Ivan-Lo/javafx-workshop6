/**
 * 
 */
function loadAllAgents() {
	var req = new XMLHttpRequest();

	req.onreadystatechange = function() {
		if (req.readyState == 4 && req.status == 200) {
			var agentsArray = JSON.parse(req.responseText);
			var agentSelect = document.getElementById("agents");

			for (i = 0; i < agentsArray.length; i++) {
				var agent = agentsArray[i];
				var option = document.createElement("option");
				option.text = agent.agtFirstName + " " + agent.agtLastName;
				option.value = agent.agentId;
				agentSelect.add(option);
			}
		}
	}
	req.open("GET", "rs/agent/getallagents");
	req.send();
}

function loadAllCustomers() {
	var req = new XMLHttpRequest();

	req.onreadystatechange = function() {
		if (req.readyState == 4 && req.status == 200) {
			var customersArray = JSON.parse(req.responseText);
			var customerSelect = document.getElementById("customers");

			for (i = 0; i < customersArray.length; i++) {
				var customer = customersArray[i];
				var option = document.createElement("option");
				option.text = customer.custFirstName + " " + customer.custLastName;
				option.value = customer.customerId;
				customerSelect.add(option);
			}
		}
	}
	req.open("GET", "rs/customer/getallcustomers");
	req.send();
}

function loadAgent(agentId) {
	console.log("in loadAgent, agentId=" + agentId);
	$.get("rs/agent/getagent/" + agentId, function(data){
			var agent = data;
			var agentDiv = document.getElementById("agentDiv");
	
			agentDiv.innerHTML = "agentId: " + agent.agentId + "<br />"
					+ "agtFirstName: " + agent.agtFirstName + "<br />"
					+ "agtMiddleInitial: " + agent.agtMiddleInitial + "<br />"
					+ "agtLastName: " + agent.agtLastName + "<br />"
					+ "agtBusPhone: " + agent.agtBusPhone + "<br />"
					+ "agtEmail: " + agent.agtEmail + "<br />"
					+ "agtPosition: " + agent.agtPosition + "<br />"
					+ "agencyId: " + agent.agencyId + "<br />" + "agtUserId: "
					+ agent.agtUserId + "<br />" + "agtPassword: "
					+ agent.agtPassword + "<br />"
		}, "json");
}

function loadCustomer(customerId) {
	console.log("in loadcustomer, customerId=" + customerId);
	$.get("rs/customer/getcustomer/" + customerId, function(data){
			var customer = data;
			var customerDiv = document.getElementById("customerDiv");
	
			customerDiv.innerHTML = "customerId: " + customer.customerId + "<br />"
					+ "custFirstName: " + customer.custFirstName + "<br />"
					+ "custLastName: " + customer.custLastName + "<br />"
					+ "custAddress: " + customer.custAddress + "<br />"
					+ "custCity: " + customer.custCity + "<br />"
					+ "custProv: " + customer.custProv + "<br />"
					+ "custPostal: " + customer.custPostal + "<br />"
					+ "custCountry: " + customer.custCountry + "<br />"
					+ "custHomePhone: " + customer.custHomePhone + "<br />"
					+ "custBusPhone: " + customer.custBusPhone + "<br />"
					+ "custEmail: " + customer.custEmail + "<br />"
					+ "agentId: " + customer.agentId + "<br />"
		}, "json");
}

function loadAgentForm(agentId) {
	console.log("in loadForm, agentId=" + agentId);
	var req = new XMLHttpRequest();

	req.onreadystatechange = function() {
		if (req.readyState == 4 && req.status == 200) {
			var agent = JSON.parse(req.responseText);
			document.getElementById("agentId").value = agent.agentId;
			document.getElementById("agtFirstName").value = agent.agtFirstName;
			document.getElementById("agtMiddleInitial").value = agent.agtMiddleInitial;
			document.getElementById("agtLastName").value = agent.agtLastName;
			document.getElementById("agtBusPhone").value = agent.agtBusPhone;
			document.getElementById("agtEmail").value = agent.agtEmail;
			document.getElementById("agtPosition").value = agent.agtPosition;
			document.getElementById("agencyId").value = agent.agencyId;
			document.getElementById("agtUserId").value = agent.agtUserId;
			document.getElementById("agtPassword").value = agent.agtPassword;
		}
	}
	req.open("GET", "rs/agent/getagent/" + agentId);
	req.send();

}

function loadCustomerForm(customerId) {
	console.log("in loadCustomerForm, customerId=" + customerId);
	var req = new XMLHttpRequest();

	req.onreadystatechange = function() {
		if (req.readyState == 4 && req.status == 200) {
			var customer = JSON.parse(req.responseText);
			document.getElementById("customerId").value = customer.customerId;
			document.getElementById("custFirstName").value = customer.custFirstName;
			document.getElementById("custLastName").value = customer.custLastName;
			document.getElementById("custAddress").value = customer.custAddress;
			document.getElementById("custCity").value = customer.custCity;
			document.getElementById("custProv").value = customer.custProv;
			document.getElementById("custPostal").value = customer.custPostal;
			document.getElementById("custCountry").value = customer.custCountry;
			document.getElementById("custHomePhone").value = customer.custHomePhone;
			document.getElementById("custBusPhone").value = customer.custBusPhone;
			document.getElementById("custEmail").value = customer.custEmail;
			document.getElementById("agentId").value = customer.agentId;
		}
	}
	req.open("GET", "rs/customer/getcustomer/" + customerId);
	req.send();

}

function updateAgent() {
	console.log("in updateAgent");
	
	//get a collection of the child nodes inside the div of fields in the agentupdate.html file 
	var divChildren = $("#myFields input");
	//create a JSON object shell
	var mydata = {};
	//loop through the fields and add the fieldname and value to the object
	for (i = 0; i < divChildren.length; i++) {
		mydata[divChildren[i].id] = divChildren[i].value;

	}
	//console.log(JSON.stringify(mydata));

	$.ajax({
		url:"rs/agent/postagent",
		type:"POST",
		data:JSON.stringify(mydata),
		complete:function(req,stat){ $("#message").html(stat); },
		success:function(data){ $("#message").append("<br />" + data); },
		dataType:"text",
		contentType:"application/json; charset=UTF-8"
	});
}

function updateCustomer() {
	console.log("in updateCustomer");
	
	//get a collection of the child nodes inside the div of fields in the agentupdate.html file 
	var divChildren = $("#myFields input");
	//create a JSON object shell
	var mydata = {};
	//loop through the fields and add the fieldname and value to the object
	for (i = 0; i < divChildren.length; i++) {
		mydata[divChildren[i].id] = divChildren[i].value;

	}
	//console.log(JSON.stringify(mydata));

	var jqxhr = $.ajax({
		url:"rs/customer/postcustomer",
		type:"POST",
		data:JSON.stringify(mydata),
		complete:function(req,stat){ $("#message").html(stat); },
		success:function(data){ $("#message").html(data); },
		dataType:"text",
		contentType:"application/json; charset=UTF-8"
	});
	
}


function insertCustomer() {
	console.log("in insertcustomer");
	
	//get a collection of the child nodes inside the div of fields in the agentupdate.html file 
	var divChildren = $("#myFields input");
	//create a JSON object shell
	var mydata = {};
	//loop through the fields and add the fieldname and value to the object
	for (i = 0; i < divChildren.length; i++) {
		mydata[divChildren[i].id] = divChildren[i].value;

	}
	//console.log(JSON.stringify(mydata));

	$.ajax({
		url:"rs/customer/putcustomer",
		type:"PUT",
		data:JSON.stringify(mydata),
		complete:function(req,stat){ $("#error").html(stat); },
		success:function(data){ $("#message").html(data); },
		dataType:"text",
		contentType:"application/json; charset=UTF-8"
	});
}


function deleteCustomer(customerId) {
	console.log("in deleteCustomer id:" + customerId);
	
	$.ajax({
		url:"rs/customer/deletecustomer/" + customerId,
		type:"DELETE",
		complete:function(req,stat){ $("#error").html(stat); },
		success:function(data){ $("#message").html(data); },
		dataType:"text",
		contentType:"application/json; charset=UTF-8"
	});
	
}