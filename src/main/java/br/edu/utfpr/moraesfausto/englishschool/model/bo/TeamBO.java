/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.model.bo;
import java.util.List;
import org.hibernate.HibernateException;
import br.edu.utfpr.moraesfausto.englishschool.model.dao.TeamDAO;
import br.edu.utfpr.moraesfausto.englishschool.model.dao.TeamDAOImpl;
import br.edu.utfpr.moraesfausto.englishschool.model.vo.Team;

/**
 *
 * @author f4ustx
 */
public class TeamBO {
    private TeamDAO TeamDAO;

    public TeamBO() {
        this.TeamDAO = new TeamDAOImpl();
    }
    
    public void save(Team Team){
        try{
          TeamDAO.save(Team);
        } catch(HibernateException he){
            System.out.println(he);
        }
    }
    public void update(Team Team){
        TeamDAO.update(Team);
    }
    public void delete(Team Team){
        TeamDAO.delete(Team);
    }
    
    public List<Team> listAll(){
        return TeamDAO.listAll();
    }
    
    public Team listById(Long id){
        return TeamDAO.listById(id);
    }
    
    public Team listByTitle(String title){
        return TeamDAO.listByTitle(title);
    } 
}
