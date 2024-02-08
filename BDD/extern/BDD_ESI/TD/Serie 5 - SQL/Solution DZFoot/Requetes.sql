--Les requêtes des différentes questions 

--Question 01
SELECT * from equipe;

--Question 02
SELECT * from joueur where equipe = 'JSK';

--Question 03
SELECT * from rencontre where ((EquipeA = 'MCA' and EquipeB= 'USMA') or (EquipeA = 'USMA' and EquipeB= 'MCA'));

--Question 04
SELECT Q, sum(points) points from
		(SELECT EquipeA , 4 points from rencontre where ButA > ButB
	UNION	
		SELECT EquipeB, 4 points from rencontre where ButB > ButA
	UNION
		SELECT EquipeA, 1 points from rencontre where ButA = ButB
	UNION 
		SELECT EquipeB, 1 points from rencontre where ButA = ButB) as F
	GROUP BY Q order by points desc

----
SELECT Q, sum(points) points from
		(SELECT EquipeA , 4 points from rencontre where ButsEquipeA > ButsEquipeB
	UNION	
		SELECT EquipeB, 4 points from rencontre where ButsEquipeB > ButsEquipeA
	UNION
		SELECT EquipeA, 1 points from rencontre where ButsEquipeA = ButsEquipeB
	UNION 
		SELECT EquipeB, 1 points from rencontre where ButsEquipeA = ButsEquipeB) as F
	GROUP BY Q order by points desc
---
	
--Question 05

--Nombre de buts par joueur
(SELECT Joueur, Equipe, count(*) buts from marquer group by Joueur, Equipe) as F;

SELECT Equipe, Joueur, B from (
								SELECT Equipe, Joueur, count(*) as B from marquer group by Equipe, Joueur) as F 
								where B = (SELECT max(B) from (
																SELECT Equipe, Joueur count(*) B from marquer group by Equipe, Joueur) as F2)
--Autre maniere
SELECT Equipe, Joueur, count(*) buts from marquer group by Equipe, Joueur
	order by buts desc LIMIT 1   --Le probleme avec limit c'est qu'on a plusieurs joueurs qui ont le mm nombre max de buts mais il affiche que le premier

--Question 06
--Choisir le max de la requete 04

--Question 07
--Le nombre de fois qu'une equipe a perdu 
SELECT EquipeA as Q, count(*) from rencontre where ButA < ButB group by EquipeA 

SELECT Q from (
				SELECT Q, sum(NB) NB from (
						SELECT EquipeA As Q, count (*) NB from rencontre where ButA < ButB group by EquipeA
					UNION
						SELECT EquipeB As Q, count (*) NB from rencontre where ButB < ButA group by EquipeB) as F
							group by Q  as M where NB = (SELECT min(NB) from (
											SELECT Q, sum(NB) NB from (
												SELECT EquipeA As Q, count (*) NB from rencontre where ButA < ButB group by EquipeA
											UNION
												SELECT EquipeB As Q, count (*) NB from rencontre where ButB < ButA group by EquipeB) as F
										group by Q ) as M ))
										
--Question 08
--on cherche l'équipe qui a reçu le moins de buts 
SELECT Q from (
				SELECT Q, sum(NB) NB from (
						SELECT EquipeA As Q, sum(ButB) NB from rencontre group by EquipeA
					UNION
						SELECT EquipeB As Q, count (*) NB from rencontre group by EquipeB) as F
							group by Q  as M where NB = (SELECT min(NB) from (
											SELECT Q, sum(NB) NB from (
												SELECT EquipeA As Q, count (*) NB from rencontre where ButA < ButB group by EquipeA
											UNION
												SELECT EquipeB As Q, count (*) NB from rencontre where ButB < ButA group by EquipeB) as F
										group by Q ) as M ))
				
				
--le gagné
select eqA from F where butA > butB union select eqB from F where butB > ButB 
Select * from rencontre where (eqA = 'JSK' and eqB = 'MCA') or (eqA= 'MCA' and eqB= 'JSK') 
	and date = (select min(date) from rencontre where (eqA = 'JSK' and eqB= 'MCA') or (eqA= 'MCA' and eqB= 'JSK') as F