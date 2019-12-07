package web.controllers;

import java.util.List;

import TPZTBCS.Guardarropa;
import TPZTBCS.Usuario;
import TPZTBCS.dao.UsuarioDao;
import spark.ModelAndView;
import spark.Spark;
import spark.Request;
import spark.Response;
import spark.template.handlebars.HandlebarsTemplateEngine;
import web.Router;
import web.models.altaPrendasModel;

public class altaPrendaController extends MainController {
	
	private static Usuario currentUser;
    private static UsuarioDao uDao = new UsuarioDao();
	private static altaPrendasModel model;
	private static final String ALTA_PRENDA = "/cliente/altaPrenda.hbs";
	private static final String ALTA_SUPERIOR = "/cliente/altaTipoSuperior.hbs";
	private static final String ALTA_INFERIOR = "/cliente/altaTipoInferior.hbs";
	private static final String ALTA_ACCESORIO = "/cliente/altaAccesorio.hbs";
	private static final String ALTA_ABRIGO = "/cliente/altaAbrigo.hbs";
	private static final String ALTA_CALZADO = "/cliente/altaCalzado.hbs";
	private static final String ALTA_ACCESORIOABRIGO = "/cliente/altaAccesorioAbrigo.hbs";
	
	
    public static void init() {
        HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();
        Spark.get(Router.altaPrendaPath(), altaPrendaController::load, engine);
        Spark.post(Router.altaPrendaPath(), altaPrendaController::redirect,engine);
        initModel();
    }
    
    private static void initModel() {
    	model = new altaPrendasModel();
         
    }
    
    private static ModelAndView load(Request request, Response response) {
        sessionExist(request, response);
        String userSession = request.session().attribute("user");
        Integer userID = Integer.parseInt(userSession.substring(0, userSession.indexOf("-")));
        currentUser = uDao.getUsuario(userID);
        model.setShowAlert(false);

        return new ModelAndView(model, ALTA_PRENDA);
    }
    private static ModelAndView redirect(Request request, Response response) {
    	String tipoPrenda = request.queryParams("prenda");

//    	No hacen falta los BREAK porque los return son lo mismo
    	switch(tipoPrenda)
    	{
    		case "ParteSuperior":
    			response.redirect(Router.getAltaSuperior());
    			return new ModelAndView(model, ALTA_SUPERIOR);
    			
    		case "ParteInferior":
    			response.redirect(Router.getAltaInferior());
    			return new ModelAndView(model, ALTA_INFERIOR);
    			
    		case "Accesorio":
    			response.redirect(Router.getAltaAccesorio());
    			return new ModelAndView(model, ALTA_ACCESORIO);
    			
    		case "Calzado":
    			response.redirect(Router.getAltaCalzado());
    			return new ModelAndView(model, ALTA_CALZADO);
    			
    		case "Abrigo":
    			response.redirect(Router.getAltaAbrigo());
    			return new ModelAndView(model, ALTA_ABRIGO);
    			
    		case "AccesorioAbrigo":
    			response.redirect(Router.getAltaAccesorioabrigo());
    			return new ModelAndView(model, ALTA_ACCESORIOABRIGO);
    			
    		default:
    			return new ModelAndView(model, ALTA_PRENDA);
    			
    	}

    	
    }
    
    
}
