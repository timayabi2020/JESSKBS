;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;  Cancer KBS              ;;
;; Created by Tim Mayabi ;;
;;            ;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(clear)
(reset)



(deftemplate Information
(slot name))

(deftemplate Internal
(slot name))

(deftemplate InternalBRD
(slot brddoc))

(deftemplate InternalUAT
(slot uatdoc))

(deftemplate InternalNDA
(slot ndadoc))

(deftemplate InternalInt
(slot intdoc)
)

(deftemplate Confirmed
(slot name)
(slot project)
)

(deftemplate External
(slot staffid)
(slot name)
(slot uatdoc)
(slot ndadoc)
(slot brddoc)
(slot integrationdoc))

(deftemplate Error
(slot error)
)

(deftemplate Type
(slot type))


(defrule GeneralInfo
    (Information (name ?name))
=>
   (printout t "Dear "?name ", Before any inhouse development starts the following documents must be presented. " crlf)
   (printout t  "1: BRD(Business Requirement document signed by all stake holders) " crlf)
   (printout t  "2: NDA(A signed non-disclosure agreement if the project will involve a vendor or a third party) " crlf)
   (printout t  "3: Integration document will be required if we are supposed to consume services rendered by the vendor " crlf)
   (printout t  "4: A signed UAT/Pilot plan document" crlf)
    
)

(defrule Confirmation
    (Confirmed (name ?name)(project ?project))
=>
 (printout t "Name:  "?name crlf)
 (printout t "Project Name:  "?project crlf)
(printout t "RequestId:  "  (round (+ (* (/ (random) 32767) 51))) crlf)
(printout t "Log on to Electronic Document management system and upload the confirmed documents. Thank you  " crlf)
   
    
)
(defrule checkInternalProjectName
	(Internal( name ?name))
	=>
(assert (validateprojectName (- ?name 0)?name))

       
)

(defrule checkInternalUAT
	(InternalUAT( uatdoc ?uatdoc))
	=>
(assert (validateuatDoc (- ?uatdoc 0)?uatdoc))

       
)

(defrule checkInternalBRD
	(InternalBRD( brddoc ?brddoc))
	=>
(assert (validatebrdDoc (- ?brddoc 0)?brddoc))

       
)

(defrule checkInternalNDA
	(InternalNDA( ndadoc ?ndadoc))
	=>
(assert (validatendaDoc (- ?ndadoc 0)?ndadoc))

       
)

(defrule checkInternalInt
	(InternalInt( intdoc ?intdoc))
	=>
(assert (validateInt (- ?intdoc 0)?intdoc))

       
)


(defrule checkProjectName
	(validateprojectName ?validateprojectName1 ?name1)(test (<= ?validateprojectName1 0))
	=>
	(assert (Error (error yes)))(printout t " Please provide a project name" crlf)
)

(defrule checkBRDDOC
	(validatebrdDoc ?validatebrdDoc1 ?brddoc1)(test (<= ?validatebrdDoc1 0))
	=>
	(printout t " BRD document is mandatory" crlf)
)

(defrule checkUATDOC
	(validateuatDoc ?validateuatDoc1 ?uatdoc1)(test (<= ?validateuatDoc1 0))
	=>
	(printout t " UAT/Pilot plan document is mandatory" crlf)
)
(defrule checkNDADOC
	(validatendaDoc ?validatendaDoc1 ?ndadoc1)(test (<= ?validatendaDoc1 0))
	=>
	(printout t " None Disclosure Agreement document is mandatory" crlf)
)

(defrule checkINTDOC
	(validateInt ?validateInt1 ?intdoc1)(test (<= ?validateInt1 0))
	=>
	(printout t " Integration document is mandatory" crlf)
)


(run)
