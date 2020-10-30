 SELECT * FROM ( SELECT DISTINCT patients.* FROM patients, declaredhcp, ovdiagnosis, officevisits, ovmedication WHERE declaredhcp.HCPID = ? AND patients.MID = declaredhcp.PatientID AND (ovdiagnosis.VisitID = officevisits.ID AND officevisits.PatientID = declaredhcp.PatientID AND ((ovdiagnosis.ICDCode >= ? AND ovdiagnosis.ICDCode < ?) OR (ovdiagnosis.ICDCode >= ? AND ovdiagnosis.ICDCode < ?) OR (ovdiagnosis.ICDCode >= ? AND ovdiagnosis.ICDCode < ?))) UNION ALL SELECT DISTINCT patients.* From patients, declaredhcp, ovdiagnosis, officevisits, ovmedication WHERE declaredhcp.HCPID = ? AND patients.MID = declaredhcp.PatientID AND (declaredhcp.PatientID = officevisits.PatientID AND officevisits.ID = ovmedication.VisitID AND ovmedication.EndDate BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 7 DAY))) AS final GROUP BY final.MID HAVING COUNT(*) = 2 ORDER BY final.lastname ASC, final.firstname ASC