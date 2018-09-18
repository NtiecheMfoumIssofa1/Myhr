-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Lun 20 Août 2018 à 22:14
-- Version du serveur :  10.1.13-MariaDB
-- Version de PHP :  5.6.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `myrh`
--

-- --------------------------------------------------------

--
-- Structure de la table `abonnement`
--

CREATE TABLE `abonnement` (
  `libelle_abonnement` varchar(255) NOT NULL,
  `cout_abonnement` double DEFAULT NULL,
  `date_abonnement` date DEFAULT NULL,
  `date_resiliation` date DEFAULT NULL,
  `desactiver` bit(1) NOT NULL,
  `etat` bit(1) NOT NULL,
  `suspendre` bit(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `abonnement`
--

INSERT INTO `abonnement` (`libelle_abonnement`, `cout_abonnement`, `date_abonnement`, `date_resiliation`, `desactiver`, `etat`, `suspendre`) VALUES
('Classic', 0, '2018-07-03', NULL, b'1', b'1', b'0'),
('Visa', 300000, '2016-11-12', NULL, b'1', b'1', b'0'),
('Premium', 500000, '2017-11-12', NULL, b'1', b'1', b'0'),
('test', 1000000, '2017-11-12', NULL, b'0', b'1', b'0');

-- --------------------------------------------------------

--
-- Structure de la table `article`
--

CREATE TABLE `article` (
  `id` bigint(20) NOT NULL,
  `contenu` varchar(255) DEFAULT NULL,
  `etat` bit(1) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `pdf` varchar(255) DEFAULT NULL,
  `id_categorie` bigint(20) DEFAULT NULL,
  `date_publication` date DEFAULT NULL,
  `date_suppression` date DEFAULT NULL,
  `nom_article` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `article`
--

INSERT INTO `article` (`id`, `contenu`, `etat`, `image`, `pdf`, `id_categorie`, `date_publication`, `date_suppression`, `nom_article`) VALUES
(1, 'la politique du cameroun depuis 1996', b'1', 'politique.jpeg', 'politique.pdf', 2, '2017-11-18', NULL, NULL),
(2, 'la politique du cameroun depuis 1996', b'0', 'politique.jpeg', 'politique.pdf', 2, '2017-11-18', NULL, NULL),
(3, 'la politique du cameroun depuis 1996', b'0', 'politique.jpeg', 'politique.pdf', 3, '2017-11-18', NULL, NULL),
(16, '<p><strong><em><span style=''font-family: "Times New Roman", Times, serif, -webkit-standard; font-size: 18px;''>xxxcvcxcxbxbxdssedsedsewd</span></em></strong></p>', b'1', NULL, NULL, 4, '2018-08-11', NULL, 'bgdged'),
(17, '<p><img src="blob:http://localhost:4200/8472273f-f00c-404c-b06f-d8f96e01720f" style="width: 124px;" class="fr-fic fr-bordered fr-fir fr-dii">uygfhjgjuguhn,lknlk,:;,</p>', b'0', NULL, NULL, 3, '2018-08-17', NULL, 'leanddddddddddd'),
(18, '<p>hvhv</p>', b'0', 'C:\\fakepath\\IMG_20171218_132622.jpg', 'C:\\fakepath\\IMG_20171225_141352.jpg', 4, '2018-08-05', NULL, 'nbvnb,');

-- --------------------------------------------------------

--
-- Structure de la table `categorie_article`
--

CREATE TABLE `categorie_article` (
  `id_categorie` bigint(20) NOT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `etat` bit(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `categorie_article`
--

INSERT INTO `categorie_article` (`id_categorie`, `libelle`, `etat`) VALUES
(1, 'sport', b'0'),
(2, 'actualite', b'1'),
(3, 'politique', b'1'),
(4, 'economique', b'1'),
(5, 'science', b'1');

-- --------------------------------------------------------

--
-- Structure de la table `document`
--

CREATE TABLE `document` (
  `intitule` varchar(255) NOT NULL,
  `archiver` bit(1) NOT NULL,
  `date_telechargement` date DEFAULT NULL,
  `etat` bit(1) NOT NULL,
  `lien_telechargement` varchar(255) DEFAULT NULL,
  `uploder` bit(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `document`
--

INSERT INTO `document` (`intitule`, `archiver`, `date_telechargement`, `etat`, `lien_telechargement`, `uploder`) VALUES
('politique', b'0', '2018-12-15', b'1', 'www.politique.doc', b'0'),
('science', b'0', '2017-12-15', b'1', 'www.science.doc', b'0'),
('Economie', b'1', '2016-12-15', b'1', 'www.economie.doc', b'0'),
('teste', b'0', '2018-08-09', b'1', '', b'0'),
('geste', b'0', '2018-08-14', b'0', '', b'0'),
('teeeeee', b'0', '2018-08-22', b'0', '', b'0'),
('youssouf', b'1', '2018-08-25', b'1', '', b'0'),
('dernier', b'1', '2018-08-15', b'0', '', b'0');

-- --------------------------------------------------------

--
-- Structure de la table `entreprise`
--

CREATE TABLE `entreprise` (
  `id` bigint(20) NOT NULL,
  `addresse` varchar(255) DEFAULT NULL,
  `confirm_password` varchar(255) DEFAULT NULL,
  `date_inscription` date DEFAULT NULL,
  `etat` bit(1) NOT NULL,
  `fonction` varchar(255) DEFAULT NULL,
  `forme_juridique` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `nom_representant` varchar(255) DEFAULT NULL,
  `nombre_employe` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `secteur_activite` varchar(255) DEFAULT NULL,
  `site_web` varchar(255) DEFAULT NULL,
  `statut` bit(1) NOT NULL,
  `taille_entreprise` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `ville` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `entreprise`
--

INSERT INTO `entreprise` (`id`, `addresse`, `confirm_password`, `date_inscription`, `etat`, `fonction`, `forme_juridique`, `nom`, `nom_representant`, `nombre_employe`, `password`, `secteur_activite`, `site_web`, `statut`, `taille_entreprise`, `telephone`, `ville`, `login`) VALUES
(2, 'douala-akwa', 'c', '2018-08-11', b'1', 'consultant web', 'start-up', 'ross', 'hitler', '10 – 20', 'c', 'Developpement', 'ross', b'1', 'Grande entreprise', '656-48+82+03', 'douala', 'employe'),
(3, 'nkolbisson', 'admin', '2018-08-18', b'1', 'directeur generale', '', 'AFROLOGIX', 'Mr narcisse', '1 – 5', 'admin', 'informatique', 'www.afrologix.com', b'0', 'Start-up', '656842830', 'yaounde', 'pass'),
(4, 'Douala', 'admin', '2018-08-12', b'1', 'consulatant', '', 'personnel', 'NTIECHE MFOUM ISSOFA', '20 – 50', 'admin', 'Ressource Humain', 'www.myhr.com', b'0', 'Grande entreprise', '654-62-38-96', 'ebolowa', 'consultant'),
(5, 'sdfgfdsq', 'e', '2018-08-12', b'1', 'hgf', '', 'gfggf', 'ngfgn', '20 – 50', 'e', 'sdfgh', 'sdfggfd', b'0', 'Grande entreprise', '656-48+82+03', 'douala', 'consultant');

-- --------------------------------------------------------

--
-- Structure de la table `equipe`
--

CREATE TABLE `equipe` (
  `id` bigint(20) NOT NULL,
  `bibliographie` varchar(255) DEFAULT NULL,
  `nom_equipe` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `prenom_equipe` varchar(255) DEFAULT NULL,
  `titre_equipe` varchar(255) DEFAULT NULL,
  `url_facebook` varchar(255) DEFAULT NULL,
  `url_linkeldn` varchar(255) DEFAULT NULL,
  `etat` bit(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `equipe`
--

INSERT INTO `equipe` (`id`, `bibliographie`, `nom_equipe`, `photo`, `prenom_equipe`, `titre_equipe`, `url_facebook`, `url_linkeldn`, `etat`) VALUES
(1, 'fdfjnb', 'developpeur', ' vnv', 'champs', 'fort', 'nvjnvj', 'jdfj', b'0'),
(2, 'bibliotheque', 'tester', 'tof', 'vendeur', 'jeu', 'facebook', 'linkedin', b'0'),
(3, 'sq', 'hsdfhsggggggggggggg', 'ezrt', 'hdsghs', 'gdshfj', 'ert', 'sdr', b'0'),
(4, 'gdcsgd', 'af', 'ejej', 'jddj', 'jdjd', 'jejj', 'jdd', b'0'),
(5, 'bcchhvd', 'hfyrg', 'C:\\fakepath\\IMG_20180525_074311.jpg', 'hfur', 'hfyu', 'bhcvdg', 'hfdfg', b'1'),
(6, 'fdfjnb', 'developpeur', 'C:\\fakepath\\tof.PNG', 'champs', 'gdshfj', 'ygtdfyd', 'jdfj', b'1'),
(7, 'ertre', 'grfgr', NULL, 'tret', 'rtre', 'rtrtre', 'rtre', b'0'),
(8, 'rerzer', 'dsdsq', 'C:\\fakepath\\IMG_20171119_214042.jpg', 'qdsqd', 'qdq', 'sdqsd', 'qsdq', b'1'),
(9, 'tytr', 'rytr', 'C:\\fakepath\\IMG_20171218_074803.jpg', 'ttryr', 'retret', 'ere', 'ert', b'1'),
(10, 'grdtre', 'tyrt', 'C:\\fakepath\\IMG_20171218_074734.jpg', 'rtyrt', 'tryrt', 'tryr', 'tyrt', b'1'),
(11, 'dycdyt', 'developpeur', 'C:\\fakepath\\IMG_20171218_074734.jpg', 'champs', 'gdshfj', 'ert', 'jdfj', b'1'),
(12, 'test', 'developpeur', 'C:\\fakepath\\IMG_20171218_074723.jpg', 'champs', 'gdshfj', 'hjbb', 'jdfj', b'1'),
(13, 'fdfsfd', 'developpeur', 'C:\\fakepath\\IMG_20171218_132622.jpg', 'champs', 'gdshfj', 'nvjnvj', 'sdr', b'1'),
(14, 'fdyg', 'fdf', 'C:\\fakepath\\IMG_20171218_074940.jpg', 'df', 'sdf', 'sd', 'sd', b'1'),
(15, 'vcvc', 'cv', 'C:\\fakepath\\tof.PNG', 'vcx', 'gfg', 'fgfg', 'fgffg', b'1');

-- --------------------------------------------------------

--
-- Structure de la table `facture`
--

CREATE TABLE `facture` (
  `idf` varchar(255) NOT NULL,
  `date` date DEFAULT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `libelle_abonnement` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `etat` bit(1) NOT NULL,
  `paiement` bit(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `facture`
--

INSERT INTO `facture` (`idf`, `date`, `designation`, `libelle_abonnement`, `login`, `etat`, `paiement`) VALUES
('F001', '2017-11-02', 'facture des Entreprise du mois de ', 'premium', 'consultant', b'1', b'1'),
('F002', '2017-11-02', 'facture des Entreprise du mois de ', 'visa', 'employe', b'1', b'1'),
('F003', '2017-11-02', 'facture des Entreprise du mois de ', 'premium', 'consultant', b'0', b'1'),
('F004', '2018-08-18', 'facture test', 'Premium', 'employe', b'0', b'1'),
('F005', '2018-08-19', 'facture des fetes', 'Visa', 'pass', b'0', b'0');

-- --------------------------------------------------------

--
-- Structure de la table `mission`
--

CREATE TABLE `mission` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `source` varchar(255) DEFAULT NULL,
  `etat` bit(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `mission`
--

INSERT INTO `mission` (`id`, `description`, `source`, `etat`) VALUES
(1, 'ureure', 'hzheuz', b'0'),
(2, 'uefhe', 'jdsshs', b'1'),
(3, 'jurehur', 'hfbhd', b'0'),
(4, 'modifier', 'moi aussi', b'1'),
(5, 'dsf', 'dvfd', b'1');

-- --------------------------------------------------------

--
-- Structure de la table `particulier`
--

CREATE TABLE `particulier` (
  `id` bigint(20) NOT NULL,
  `entreprise` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `fonction` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `sexe` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `etat` bit(1) NOT NULL,
  `statut` bit(1) NOT NULL,
  `date_inscription` date DEFAULT NULL,
  `ville` varchar(255) DEFAULT NULL,
  `confirm_password` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `particulier`
--

INSERT INTO `particulier` (`id`, `entreprise`, `first_name`, `fonction`, `last_name`, `mail`, `sexe`, `telephone`, `login`, `etat`, `statut`, `date_inscription`, `ville`, `confirm_password`, `password`) VALUES
(1, 'afrologix', 'tatiana', 'employé', 'tatiana', 'test2@gmail.com', 'feminin', '656-48-82-03', 'consultant', b'1', b'1', '2017-07-18', NULL, NULL, NULL),
(2, 'afrologix', 'morel', 'employé', 'choupo', 'test1@gmail.com', 'Masculin', '656-48-82-03', 'consultant', b'1', b'1', '2019-07-18', NULL, NULL, NULL),
(3, 'afrologix', 'ross', 'employé', 'le grand', 'test2@gmail.com', 'Masculin', '656-48-82-03', 'consultant', b'1', b'1', '2017-07-18', NULL, NULL, NULL),
(4, 'afrologix', 'bill', 'employé', 'gate', 'test2@gmail.com', 'Masculin', '656-48-82-03', 'consultant', b'1', b'1', '2017-07-18', NULL, NULL, NULL),
(5, 'afrologix', 'tati', 'employé', 'tatiana', 'test2@gmail.com', 'feminin', '656-48-82-03', 'consultant', b'1', b'1', '2017-07-18', NULL, NULL, NULL),
(6, 'afrologix', 'tati', 'employé', 'tatiana', 'test2@gmail.com', 'feminin', '656-48-82-03', 'consultant', b'1', b'1', '2017-07-18', NULL, NULL, NULL),
(7, 'sdf', 'xwcxcxwxwxc', 'dfg', 'xxwcxwc', 'c@g.com', 'Masculin', 'sdfgh', 'employe', b'1', b'1', '2018-08-11', 'sdfg', 'd', 'd'),
(8, 'bbb', 'n', 'bn', 'bn', 'c@g.com', 'Feminin', 'h', 'pass', b'1', b'1', '2018-08-19', ' bbb', 'v', 'v'),
(9, 'afrologix', 'ntieche', 'developpeur web', 'mfoum issofa', 'hfhfh', 'Homme', '656-48-82-02', 'employe', b'1', b'1', '2018-08-12', 'douala', 'e', 'e'),
(10, 'EZRTY', 'YRFRREY', 'EZRT', 'ZERT', 'QZER', 'Homme', '656-48-82-03', 'admin', b'1', b'1', '2018-08-12', 'SQZER', 'Y', 'Y'),
(11, 'hvxcgv', 'utryrtytry', 'cvxcvh', 'jf', 'bcbb', 'Homme', 'nvbvcjb', 'admin', b'1', b'1', '2018-08-05', 'vchh', 'f', 'f'),
(12, 'moi', 'nbcvnbv', 'toi', 'fd', 'g@g.com', 'Homme', '656-48-82-03', 'pass', b'1', b'1', '2018-08-19', 'doala', 't', 't'),
(13, 'jkl', 'dfg', 'jk', 'zert', 'bnk,', 'Homme', '656-48+82+03', 'pass', b'1', b'1', NULL, 'jkl', '', ''),
(14, 'jkl', 'dfg', 'jk', 'zert', 'bnk,', 'Homme', '656-48+82+03', 'pass', b'1', b'1', NULL, 'jkl', '', ''),
(15, 'gvd', 'hfvhfdhhg', 'jhvjb', 'hcg', 'hvgfdg', 'Homme', '656-48+82+03', 'pass', b'1', b'1', NULL, 'bhcv', '', ''),
(16, '', 't', '', '', '', '', '', 'employe', b'0', b'1', NULL, '', '', ''),
(17, 'dsfg', 'wsdf', 'sdfg', 'sqdfg', 'sq', 'Masculin', '656-48+82+03', 'employe', b'0', b'1', '2018-08-30', 'sdgf', 'c', 'c'),
(18, 'afrologix', 'ntieche Mfoum', 'developpeur web', 'issofa', 'i@g.com', 'Homme', '656488203', 'employe', b'1', b'1', '2018-08-18', 'koutaba', 'v', 'v'),
(19, 'afrologix', 'ntieche', 'developpeur web', 'mfoum issofa', 'g@g.com', 'Homme', '656-48-82-03', 'consultant', b'1', b'1', '2018-08-11', 'yaounde', 'admin', 'admin'),
(20, 'moi', 'r', '', 'r', 'g@g.com', 'Femme', '656-48+82+03', 'employe', b'1', b'1', '2018-08-12', 'douala', 'f', 'f'),
(21, 'hvxcgv', 'utryrtytry', 'sdfgh', 'mfoum issofa', 'g@g.com', 'Homme', '656-48+82+03', 'employe', b'1', b'1', '2018-08-12', 'yaounde', 'c', 'c');

-- --------------------------------------------------------

--
-- Structure de la table `profil`
--

CREATE TABLE `profil` (
  `idprofil` bigint(20) NOT NULL,
  `etat` bit(1) NOT NULL,
  `libelle_profil` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `profil`
--

INSERT INTO `profil` (`idprofil`, `etat`, `libelle_profil`) VALUES
(1, b'1', 'directeur Generales'),
(2, b'1', 'directeur Generale Adjoint'),
(3, b'0', 'test'),
(4, b'1', 'magasinier'),
(8, b'0', 'mode'),
(6, b'0', 'bravo'),
(7, b'1', 'ajouter'),
(9, b'0', 'mode'),
(10, b'0', 'admin'),
(11, b'0', 'user'),
(12, b'0', 'user'),
(13, b'0', 'van'),
(14, b'0', 'tester'),
(15, b'0', 'test'),
(16, b'1', 'testmodifier');

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

CREATE TABLE `reservation` (
  `id` bigint(20) NOT NULL,
  `annule` bit(1) NOT NULL,
  `date_debut` date DEFAULT NULL,
  `date_fin` date DEFAULT NULL,
  `etat` bit(1) NOT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `statut` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `objet` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `reservation`
--

INSERT INTO `reservation` (`id`, `annule`, `date_debut`, `date_fin`, `etat`, `libelle`, `statut`, `login`, `objet`) VALUES
(1, b'0', '2017-11-02', NULL, b'0', 'contrat de travaille', 'Debut', 'employe', NULL),
(2, b'1', '2017-11-02', NULL, b'0', 'conseil juridique', 'encours', 'consultant', NULL),
(3, b'0', '2018-11-02', NULL, b'1', 'organigramme entreprise', 'Debut', 'employe', 'modifier'),
(4, b'0', '2017-11-02', NULL, b'0', 'conseil juridique', 'Debut', 'consultant', NULL),
(5, b'1', '2018-08-09', NULL, b'1', 'gdgdgdg', 'Debut', 'pass', 'je suis fort'),
(6, b'0', '2018-08-10', NULL, b'0', 'uy"ré"', 'Debut', 'pass', 'hhfhfhfhfhfhf'),
(7, b'0', NULL, NULL, b'0', 'rurutr', 'Debut', 'employe', 'hyr''(''"gtg('),
(8, b'1', '2018-08-09', NULL, b'0', 'xcxc', 'Debut', 'admin', 'xwxwcx');

-- --------------------------------------------------------

--
-- Structure de la table `reservation_produit`
--

CREATE TABLE `reservation_produit` (
  `id` bigint(20) NOT NULL,
  `idp` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

CREATE TABLE `role` (
  `role` varchar(255) NOT NULL,
  `etat` bit(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `role`
--

INSERT INTO `role` (`role`, `etat`) VALUES
('ADMIN', b'1'),
('EMPLOYE', b'1'),
('CONSULTANT', b'1'),
('PROFESSIONNEL', b'1'),
('TEST', b'0'),
('TESTRRRRRRRRRRRRR', b'0'),
('dsqfdsfds', b'0'),
('papa', b'0'),
('jeu', b'0'),
('aaaaaaaaaaaaaaaaaaaaa', b'0'),
('vendeur', b'0');

-- --------------------------------------------------------

--
-- Structure de la table `service_categorie`
--

CREATE TABLE `service_categorie` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `etat` bit(1) NOT NULL,
  `source` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `service_categorie`
--

INSERT INTO `service_categorie` (`id`, `description`, `etat`, `source`) VALUES
(1, 'presenter', b'1', 'n,fkjgnd'),
(2, 'uefhe', b'0', 'jeanne'),
(3, 'nbdchbbcd', b'1', 'njdfnjd');

-- --------------------------------------------------------

--
-- Structure de la table `service_produit`
--

CREATE TABLE `service_produit` (
  `idp` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `prix` double DEFAULT NULL,
  `id` bigint(20) DEFAULT NULL,
  `etat` bit(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `service_produit`
--

INSERT INTO `service_produit` (`idp`, `description`, `libelle`, `prix`, `id`, `etat`) VALUES
(1, 'hgsd', 'test', 50000, 1, b'1'),
(2, 'jjjjjjjjjjjjj', 'vvvvvvvvvvvv', 6000, 1, b'1'),
(3, 'tes', 'tes', 50000, 3, b'1'),
(4, 'cvgdsjd', 'hdhghgsd', 4500, 1, b'0'),
(5, 'gsqhdhqs', 'blabla', 50000, 3, b'0'),
(6, 'gsqhdhqs', 'bhsdghsq', 50000, 1, b'0');

-- --------------------------------------------------------

--
-- Structure de la table `user_doc`
--

CREATE TABLE `user_doc` (
  `intitule` varchar(255) NOT NULL,
  `login` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `user_doc`
--

INSERT INTO `user_doc` (`intitule`, `login`) VALUES
('economie', 'employe'),
('politique', 'consultant');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `login` varchar(255) NOT NULL,
  `etat` bit(1) NOT NULL,
  `statut` bit(1) NOT NULL,
  `idprofil` bigint(20) DEFAULT NULL,
  `libelle_abonnement` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`login`, `etat`, `statut`, `idprofil`, `libelle_abonnement`) VALUES
('admin', b'1', b'1', 1, 'Classic'),
('employe', b'1', b'1', 4, 'premium'),
('consultant', b'1', b'1', 4, 'visa'),
('pass', b'1', b'1', 4, 'Premium');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur_roles`
--

CREATE TABLE `utilisateur_roles` (
  `login` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `utilisateur_roles`
--

INSERT INTO `utilisateur_roles` (`login`, `role`) VALUES
('admin', 'ADMIN'),
('admin', 'EMPLOYE'),
('employe', 'EMPLOYE'),
('consultant', 'CONSULTANT'),
('admin', 'CONSULTANT'),
('admin', 'PROFESSIONNEL');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `abonnement`
--
ALTER TABLE `abonnement`
  ADD PRIMARY KEY (`libelle_abonnement`);

--
-- Index pour la table `article`
--
ALTER TABLE `article`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKht3oqb17uxsxomohnrom9lytu` (`id_categorie`);

--
-- Index pour la table `categorie_article`
--
ALTER TABLE `categorie_article`
  ADD PRIMARY KEY (`id_categorie`);

--
-- Index pour la table `document`
--
ALTER TABLE `document`
  ADD PRIMARY KEY (`intitule`);

--
-- Index pour la table `entreprise`
--
ALTER TABLE `entreprise`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK2ov7qgphq71ie8qq63tmrllho` (`login`);

--
-- Index pour la table `equipe`
--
ALTER TABLE `equipe`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `facture`
--
ALTER TABLE `facture`
  ADD PRIMARY KEY (`idf`),
  ADD KEY `FKi504b0r9jcacupii35vw94dg5` (`libelle_abonnement`),
  ADD KEY `FKro7oanf1jmgvvduyk38dsj8wg` (`login`);

--
-- Index pour la table `mission`
--
ALTER TABLE `mission`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `particulier`
--
ALTER TABLE `particulier`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKs68j6cnhrf4r58ft4fbx7o4kp` (`login`);

--
-- Index pour la table `profil`
--
ALTER TABLE `profil`
  ADD PRIMARY KEY (`idprofil`);

--
-- Index pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKf0lj0t06baab1wr66vr3d4gf4` (`login`);

--
-- Index pour la table `reservation_produit`
--
ALTER TABLE `reservation_produit`
  ADD KEY `FK85tefosri40qcb2k9l04903ja` (`idp`),
  ADD KEY `FKgxin23q1ovagvlkj1nn4inesl` (`id`);

--
-- Index pour la table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`role`);

--
-- Index pour la table `service_categorie`
--
ALTER TABLE `service_categorie`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `service_produit`
--
ALTER TABLE `service_produit`
  ADD PRIMARY KEY (`idp`),
  ADD KEY `FK89a9ynv0xbrom3o6ddqiul3q5` (`id`);

--
-- Index pour la table `user_doc`
--
ALTER TABLE `user_doc`
  ADD KEY `FKnulq2wwojywxh09hdpxvo9nc5` (`login`),
  ADD KEY `FKkfeu3m30psg799ntv7eo0rxjc` (`intitule`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`login`),
  ADD KEY `FK76n94b2qypcw38o4j006fkbjs` (`libelle_abonnement`),
  ADD KEY `FKa4cjexkxorar125i6u8ka9e0b` (`idprofil`);

--
-- Index pour la table `utilisateur_roles`
--
ALTER TABLE `utilisateur_roles`
  ADD KEY `FKtopai0j446dyuog71rra29vfw` (`role`),
  ADD KEY `FK8nrryuwb4156whc2d3a7pmek` (`login`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `article`
--
ALTER TABLE `article`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT pour la table `categorie_article`
--
ALTER TABLE `categorie_article`
  MODIFY `id_categorie` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT pour la table `entreprise`
--
ALTER TABLE `entreprise`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT pour la table `equipe`
--
ALTER TABLE `equipe`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT pour la table `mission`
--
ALTER TABLE `mission`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT pour la table `particulier`
--
ALTER TABLE `particulier`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT pour la table `profil`
--
ALTER TABLE `profil`
  MODIFY `idprofil` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT pour la table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT pour la table `service_categorie`
--
ALTER TABLE `service_categorie`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `service_produit`
--
ALTER TABLE `service_produit`
  MODIFY `idp` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
