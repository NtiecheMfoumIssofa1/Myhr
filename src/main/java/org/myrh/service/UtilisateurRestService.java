package org.myrh.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.myrh.entities.Utilisateur;
import org.myrh.metier.UtilisateurMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class UtilisateurRestService {
	@Autowired
	private UtilisateurMetier utilisateurMetier;
	
	//@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value="/user/{p}/{a}",method=RequestMethod.POST)
	public Utilisateur saveUser(@RequestBody Utilisateur u, @PathVariable Long p, @PathVariable String a ) {
		return utilisateurMetier.saveUser(u,p,a);
	}
	//@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value="/user/{idUser}/{p}/{a}",method=RequestMethod.PUT)
	public Utilisateur updateUser(@PathVariable String idUser, @RequestBody Utilisateur u,@PathVariable Long p, @PathVariable String a) {
		
		return utilisateurMetier.updateUser(idUser, u,p,a);
	}
	//@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value="/user/{idUser}",method=RequestMethod.DELETE)
	public boolean deleteUser(@PathVariable String idUser) {
		return utilisateurMetier.deleteUser(idUser);
	}
	@RequestMapping(value="/userId/{login}",method=RequestMethod.GET)
	public Utilisateur getUser(@PathVariable String login) {
		return utilisateurMetier.getUser(login);
	}
	//@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value="/user",method=RequestMethod.GET)
	public List<Utilisateur> getAllUser() {
		return utilisateurMetier.getAllUser();
	}
	//@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value="/userParMc",method=RequestMethod.GET)
	public Page<Utilisateur> getAllUserParMc(
			@RequestParam(name="mc",defaultValue="")String mc, 
			@RequestParam(name="page",defaultValue="0")int page, 
			@RequestParam(name="size",defaultValue="5")int size) {
		return utilisateurMetier.getAllUserParMc(mc, page, size);
	}
	//@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value="/userActif",method=RequestMethod.GET)
	public List<Utilisateur> getAllActif() {
		return utilisateurMetier.getAllActif();
	}
	//@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value="/addRoleToUser/{idUser}/{idRole}",method=RequestMethod.POST)
	public void addRoleToUser(@PathVariable String idUser, @PathVariable String idRole) {
		 utilisateurMetier.addRoleToUser(idUser, idRole);
	}
	//@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value="/userRole/{idRole}",method=RequestMethod.GET)
	public List<Utilisateur> getAllParRole(@PathVariable String idRole) {
		return utilisateurMetier.getAllParRole(idRole);
	}
	/*@Secured(value={"ROLE_ADMIN","ROLE_EMPLOYE"})
	@RequestMapping(value="/getLogedUser")
	public Map<String, Object> consulUserAuthentifier(HttpServletRequest httpServletRequest){
		HttpSession httpSession=httpServletRequest.getSession();//permet de récupérer la session encours
		SecurityContext securityContext=(SecurityContext) 
				httpSession.getAttribute("SPRING_SECURITY_CONTEXT");//recupere l'attribut SPRING_SECURITY_CONTEXT(contexte de la securité) stocker dans SecurityContext
		String username= securityContext.getAuthentication().getName();//recupere le nom de l'user authentifé
		utilisateurMetier.activeUser(username);
		//recuperation de la liste des roles d'un user
		List<String> roles= new ArrayList<>();
		for(GrantedAuthority ga : securityContext.getAuthentication().getAuthorities()){
			roles.add(ga.getAuthority()); //recupere differents roles des utilisateurs
		}
		//ajout de l'user et ces roles dans une collection Map
		Map<String, Object> params = new HashMap<>();
		params.put("username", username);
		params.put("roles", roles);
		return params;
	}*/

}
