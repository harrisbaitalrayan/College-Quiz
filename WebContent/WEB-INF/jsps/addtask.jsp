<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Add Task Form</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/addtask.css" />

<style type="text/css">
</style>
</head>
<body>
	<h1>Add Task Form</h1>
	<div class="info"></div>

	<form>


		<div class="contentform">
			<div id="sendmessage">Your message has been sent successfully.
				Thank you.</div>


			<div class="leftcontactnoneed">
				<div class="form-group">
					<p>
						Add Task<span>*</span>
					</p>
					<input type="text" name="nom" id="nom" data-rule="required"
						data-msg="VÃ©rifiez votre saisie sur les champs : Le champ 'Nom' doit Ãªtre renseignÃ©." />
					<div class="validation"></div>
				</div>

				<div class="form-group">
					<p>
						Employee Name<span>*</span>
					</p>
					<input type="text" name="nom" id="nom" data-rule="required"
						data-msg="VÃ©rifiez votre saisie sur les champs : Le champ 'Nom' doit Ãªtre renseignÃ©." />
					<div class="validation"></div>
				</div>

				<div class="form-group">
					<p>
						Department<span>*</span>
					</p>
					<input type="text" name="nom" id="nom" data-rule="required"
						data-msg="VÃ©rifiez votre saisie sur les champs : Le champ 'Nom' doit Ãªtre renseignÃ©." />
					<div class="validation"></div>
				</div>

				<div class="form-group">
					<p>
						Task Details<span>*</span>
					</p>
					<textarea name="message" rows="14" data-rule="required"
						data-msg="Vérifiez votre saisie sur les champs : Le champ 'Message' doit être renseigné."></textarea>
					<div class="validation"></div>
				</div>

				<div class="form-group">
					<p>
						Start Date<span>*</span>
					</p>
					<input type="text" name="nom" id="nom" data-rule="required"
						data-msg="VÃ©rifiez votre saisie sur les champs : Le champ 'Nom' doit Ãªtre renseignÃ©." />
					<div class="validation"></div>
				</div>

				<div class="form-group">
					<p>
						End Date<span>*</span>
					</p>
					<input type="text" name="nom" id="nom" data-rule="required"
						data-msg="VÃ©rifiez votre saisie sur les champs : Le champ 'Nom' doit Ãªtre renseignÃ©." />
					<div class="validation"></div>
				</div>




			</div>


		</div>
		<button type="submit" class="bouton-contact">Send</button>

	</form>


</body>
</html>