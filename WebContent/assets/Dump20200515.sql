CREATE DATABASE  IF NOT EXISTS `web` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `web`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: web
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `belongs`
--

DROP TABLE IF EXISTS `belongs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `belongs` (
  `product` int NOT NULL,
  `category` varchar(45) NOT NULL,
  PRIMARY KEY (`product`,`category`),
  KEY `category_id_idx` (`category`),
  CONSTRAINT `category_id` FOREIGN KEY (`category`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `product_id3` FOREIGN KEY (`product`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `belongs`
--

LOCK TABLES `belongs` WRITE;
/*!40000 ALTER TABLE `belongs` DISABLE KEYS */;
/*!40000 ALTER TABLE `belongs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES ('iot','IoT'),('kit','Kit'),('main','In primo piano'),('schede','Schede'),('sensori','Sensori');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contains`
--

DROP TABLE IF EXISTS `contains`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contains` (
  `order_id` int NOT NULL,
  `product_id` int NOT NULL,
  `price` decimal(2,0) NOT NULL,
  `quantity` decimal(2,0) NOT NULL,
  PRIMARY KEY (`order_id`,`product_id`),
  KEY `product_id_idx` (`product_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `order_id2` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `product_id2` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contains`
--

LOCK TABLES `contains` WRITE;
/*!40000 ALTER TABLE `contains` DISABLE KEYS */;
/*!40000 ALTER TABLE `contains` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `has_shipping`
--

DROP TABLE IF EXISTS `has_shipping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `has_shipping` (
  `shipping_info_id` int NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`shipping_info_id`,`user_id`),
  KEY `user_id_idx` (`user_id`),
  CONSTRAINT `shipping_info_id` FOREIGN KEY (`shipping_info_id`) REFERENCES `shipping_info` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `has_shipping`
--

LOCK TABLES `has_shipping` WRITE;
/*!40000 ALTER TABLE `has_shipping` DISABLE KEYS */;
/*!40000 ALTER TABLE `has_shipping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `image`
--

DROP TABLE IF EXISTS `image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `image` (
  `id` int NOT NULL auto_increment,
  `img` MEDIUMBLOB NOT NULL,
  `product_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `product_id4_idx` (`product_id`),
  CONSTRAINT `product_id4` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image`
--

LOCK TABLES `image` WRITE;
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
/*!40000 ALTER TABLE `image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `make`
--

DROP TABLE IF EXISTS `make`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `make` (
  `order_id` int NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`order_id`,`user_id`),
  KEY `user_id_idx` (`user_id`),
  CONSTRAINT `order_id` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_id2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `make`
--

LOCK TABLES `make` WRITE;
/*!40000 ALTER TABLE `make` DISABLE KEYS */;
/*!40000 ALTER TABLE `make` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL,
  `iva` int NOT NULL,
  `city` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `state` varchar(45) NOT NULL,
  `zip_code` varchar(45) NOT NULL,
  `details` varchar(45) DEFAULT NULL,
  `track_id` varchar(45) DEFAULT NULL,
  `shipping_price` varchar(45) NOT NULL,
  `payment_id` int NOT NULL,
  `shipping_type_id` int NOT NULL,
  `payment_code` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`,`iva`,`shipping_price`),
  KEY `shipping_type_idx` (`shipping_type_id`),
  CONSTRAINT `shipping_type` FOREIGN KEY (`shipping_type_id`) REFERENCES `shipping_type` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `price` decimal(6,3) NOT NULL,
  `name` varchar(45) NOT NULL,
  `description` mediumtext,
  `visible` tinyint NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,25.000,'Arduino Uno','Scheda programmabile, ci fai tante cose carine e cucciolose',1),(2,50.000,'Raspberry Pi 4','Il Raspberry Pi è un computer a basso costo, formato carta di credito, che si collega al monitor di un computer o alla TV e utilizza una tastiera e un mouse standard. È un piccolo dispositivo capace che permette a persone di tutte le età di esplorare l\'informatica e di imparare a programmare in linguaggi come Scratch e Python.',1),(3,70.500,'Raspberry Kit','Questo kit include: Raspberry Pi, case, alimentatore, cavo hdmi, dissipatori, connettore GPIO',1),(4,80.810,'Arduino Uno Starter Kit','Le schede ELEGOO possono essere utilizzate come il cervello dietro a qualsiasi progetto di elettronica. Può interagire con pulsanti, LED, motori, altoparlanti, unità GPS, videocamere, Internet e persino il tuo smartphone o la tua TV! Collegando la scheda ELEGOO con un personal computer tramite un cavo USB e caricando programmi sulla scheda, gli utenti possono creare dispositivi digitali e oggetti interattivi in grado di rilevare e controllare oggetti nel mondo fisico e digitale come robot o persino onesti programmatori di cartomanzia.',1),(5,29.990,'LIFX Mini Day&Dusk E27 ','Il design compatto di LIFX Mini Day & Dusk fornisce uno spettro di luce ispirato al sole, è dotato di facile automazione un click, per fornire una luce naturale che si adatti durante il giorno. L’illuminazione varierà gradualmente in base ad una sequenza specifica per adeguarsi alle tue esigenze. Sia se si accende una singola luce sia se si attenua tutta l’illuminazione, ogni luce è dotata di tecnologia Wi-Fi per connessioni ininterrotte e indisturbate alle principali piattaforme e dispositivi domestici intelligenti.',1),(6,3.900,'Sensore di prossimità a infrarosso ','Sensore rilevatore di prossimità a infrarosso, consente di pilotare la vostra car robot evitando gli ostacoli, o di individuare oggetti di colore diverso. Distanza di rilevamento: 1 - 8mm. Tensione di funzionamento: 3.3 - 5V Corrente di lavoro ≥ 20mA Temperatura di esercizio -10°C fino +50°C Distanza di rilevamento massima 2,5cm Trimmer di regolazione sensibilità rilevamento Uscita digitale livello TTL (BASSO (=0V) con ostacolo, o ALTO (=VCC) senza ostacolo) Uscita analogica Utilizza circuito integrato LM393 Angolo effettivo 35° LED di accensione modulo (rosso) LED di rilevamento ostacolo (verde) Dimensioni (L x W): 3.1 x 1.4 cm. Peso: 3g. circa Contenuto della confezione: 1 x FC-51',1),(7,20.990,'Display LCD 3.2 Pollici MHS RPi ','Features: 1.Physical resolution 320 x 480, with resistive touch control.',1),(8,15.990,'SIM Card Things Mobile prepagata per IOT','Things Mobile è l’operatore mobile globale dedicato ai dispositivi IoT e M2M con copertura in più di 165 Paesi e oltre 250 operatori di roaming. Things Mobile garantisce ovunque massima qualità e affidabilità di segnale, anche nelle zone più difficoltose e meno raggiungibili. La SIM Things Mobile è disponibile in tutti i formati: mini, micro, nano e SIM-On-Chip. Things mobile ha una tariffa a consumo, a pacchetto, unlimited e personalizzabili, senza costi iniziali, senza canone e offre accesso gratuito ad una piattaforma web completa ed efficace. La flessibilità e la scalabilità delle soluzioni di Things Mobile consentono di creare ambienti di vita più sostenibili, di razionalizzare e rendere più efficienti i servizi, di ottimizzare il consumo energetico fino a creare vere e proprie Smart Cities, città intelligenti e sostenibili. Con Things Mobile puoi creare un mondo più smart, nel quale la tecnologia è in grado di cambiare in maniera significativa la vita delle persone, grazie al vero potere racchiuso nella possibilità di scambiare dati tra dispositivi e sistemi mobili in tutto il mondo. La SIM Things Mobile è ideale per: IoT, M2M, GPS Tracker, Allarmi, Domotica, Pos, Smartwatch, Vending Machine, Telemetria, Microcontrollori, PLC, Caldaie, Condizionatori, Contatori dell\'acqua, Contatori del gas, Contatori dell\'energia, Termostati, Videocitofoni, Apriporta, Elettrodomestici, Videocamere, Gateway, Modem, Router, Industrial IoT, Apricancello, Tagliaerba, Colonnine di ricarica, Lampioni pubblici, Sensori industriali, Prese intelligenti, Automotive, fotovoltaico, Irrigatori, Telecontrollo, Cronotermostato, ecc. Nota: L’immagine è puramente indicativa e al solo scopo illustrativo.',1),(9,99.990,'SUNFOUNDER RasPad - A Raspberry Pi Tablet','SunFounder Raspad, un tablet portatile all-in-one Raspberry Pi, con accesso a tutte le porte Raspberry Pi per connettere qualsiasi periferica necessaria per creare progetti personalizzati.',1),(10,15.990,'Arduino Nano','La scheda Elegoo Nano è una scheda piccola, completa e adatta alla breadboard basata su ATmega328P e funziona con un cavo mini USB. Elegoo Nano può essere alimentato tramite connessione USB, alimentatore esterno non regolato 6-12 V (pin 30) o alimentatore esterno regolato a 5 V (pin 27). Elegoo Nano ha una varietà di servizi per comunicare con un PC o altri microcontrollori. L\'Elegoo Nano può essere resettato dal software in esecuzione su un computer collegato.',1),(11,2.500,'Sensore ad Ultrasuoni','Sensore ad ultrasuoni completo di istruzioni per il collegamento a schede Arduino',1);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipping_info`
--

DROP TABLE IF EXISTS `shipping_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shipping_info` (
  `id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(45) NOT NULL,
  `state` varchar(45) NOT NULL,
  `zip_code` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipping_info`
--

LOCK TABLES `shipping_info` WRITE;
/*!40000 ALTER TABLE `shipping_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `shipping_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipping_type`
--

DROP TABLE IF EXISTS `shipping_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shipping_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `price` decimal(5,2) DEFAULT NULL,
  `days` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipping_type`
--

LOCK TABLES `shipping_type` WRITE;
/*!40000 ALTER TABLE `shipping_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `shipping_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `is_admin` tinyint NOT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Lorenzo','Criscuolo','admin@admin.com',1,NULL,'password'),(2,'Prova','Utente','test@test.com',0,NULL,'test'),(3,'Prova','Test','try@try.com',0,NULL,'psw');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-15 20:38:19
