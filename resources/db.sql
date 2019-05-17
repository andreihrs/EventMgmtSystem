CREATE TABLE `agency` (
  `idagency` int(11) NOT NULL,
  `agency_name` varchar(45) NOT NULL,
  `has_registered` tinyint(4) NOT NULL,
  `price_paid` int(11) NOT NULL,
  `discount` int(11) NOT NULL,
  PRIMARY KEY (`idagency`)
);

INSERT INTO `proiectpao`.`agency`
(`agency_name`,
`has_registered`,
`price_paid`,
`discount`)
VALUES
('Revolut',
 1,
 1321,
 300);