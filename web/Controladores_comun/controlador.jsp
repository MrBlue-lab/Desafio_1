<%-- 
    Document   : controlador
    Created on : 25 sept. 2020, 13:24:03
    Author     : daw205
--%>
<%@page import="Modelo.ConexionEstatica"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.LinkedList"%>
<%@page import="Modelo.User"%>
<%
    //metodo para regresar en cualquier pagina
    if (request.getParameter("back") != null) {
        if (session.getAttribute("logueado") != null) {
            session.removeAttribute("logueado");
        }
        response.sendRedirect("../index.jsp");
    }

    //Redireccionamiento de paginas
    if (request.getParameter("registrar") != null) {
        response.sendRedirect("../vistas_comun/registrar.jsp");
    }

    //Registro de usuarios
    if (request.getParameter("registro") != null) {
        String email = request.getParameter("email");
        String nick = request.getParameter("nickname");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String pass = request.getParameter("pass");
        String sexo = request.getParameter("sexo");
        String aux = request.getParameter("edad");
        int edad = Integer.parseInt(aux);
        User u = new User(email, pass, nombre, nick, apellido, edad, sexo);
        ConexionEstatica.Insertar_User(u);
        response.sendRedirect("../index.jsp");
    }

    //Comprobacion de usuarios
    if (request.getParameter("loguin") != null) {
        String user = request.getParameter("usuario");
        String pass = request.getParameter("contrasena");
        if (ConexionEstatica.loguin(user, pass) != null) {
            User u = ConexionEstatica.loguin(user, pass);
            if (ConexionEstatica.User_tiene_casa(u.getId()).equals("")) {
                response.sendRedirect("../vistas_comun/preferencias.jsp");
            } else {
                response.sendRedirect("../vistas_comun/eleccion.jsp");
                u.setCasa(ConexionEstatica.User_tiene_casa(u.getId()));
            }
            session.setAttribute("logueado", u);
        } else {
            response.sendRedirect("../index.jsp");
        }
    }

    //eleccion de usuario logueado
    if (request.getParameter("eleccion") != null) {
        String aux = request.getParameter("tipo");
        if (Integer.parseInt(aux) == 2) {
            response.sendRedirect("../Controladores_admin/admin.jsp");
        } else {
            response.sendRedirect("../vistas_user/home.jsp");
        }
    }

    //eleccion de usuario logueado primera vez
    if (request.getParameter("preferencias") != null) {
        int casa = 0;
        int sombrero = 0;
        for (int i = 0; i < 10; i++) {
            String aux = request.getParameter("" + i);
            casa = casa + Integer.parseInt(aux);
        }
        if (casa >= 100 && casa <= 170) {
            sombrero = 4;
        } else if (casa >= 180 && casa <= 250) {
            sombrero = 3;
        } else if (casa >= 260 && casa <= 320) {
            sombrero = 2;
        } else if (casa >= 330 && casa <= 400) {
            sombrero = 1;
        }

        User u = (User) session.getAttribute("logueado");
        ConexionEstatica.sombrero_seleccionador(sombrero, u.getId(), casa);
        u.setCasa(ConexionEstatica.User_tiene_casa(u.getId()));
        session.setAttribute("logueado", u);
        response.sendRedirect("../vistas_comun/eleccion.jsp");
    }
%>