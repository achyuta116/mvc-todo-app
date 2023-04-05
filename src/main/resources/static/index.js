const descInputBox = document.querySelector('#description')
const titleInputBox = document.querySelector('#title')

const submitButton = document.querySelector('#submit')
const list = document.querySelector('#list')

submitButton.addEventListener('click', () => {
	console.log('clicked')
	console.log(descInputBox)
	console.log(titleInputBox)
	fetch('http://localhost:8080/todos/', {
		method: 'POST',
		headers: new Headers({
			'Content-Type': 'application/json',
		}),
		body: JSON.stringify({
			title: titleInputBox.value,
			description: descInputBox.value,
		}),
	})
		.then((res) => res.json())
		.then((data) => {
			const li = document.createElement('li')
			const title = document.createElement('div')
			title.appendChild(document.createTextNode(data.title))
			li.appendChild(title)
			const description = document.createElement('div')
			description.appendChild(document.createTextNode(data.description))
			li.appendChild(description)
			li.classList.add('todo')
			li.setAttribute('data-id', data.id)
			li.addEventListener('click', async () => {
				if (confirm('Do you want to update this item?')) {
					const newDesc = prompt('Update description to?')
					await fetch(`http://localhost:8080/todos/${Number(data.id)}`, {
						method: 'PUT',
						headers: new Headers({
							'Content-Type': 'application/json',
						}),
						body: newDesc,
					})
					if (newDesc)
						li.querySelector('div:nth-child(2)').textContent = newDesc
				} else if (confirm('Do you want to delete this item?')) {
					list.removeChild(document.querySelector(`[data-id='${data.id}']`))
					fetch(`http://localhost:8080/todos/${Number(data.id)}`, {
						method: 'DELETE',
					})
				}
			})
			list.appendChild(li)
			titleInputBox.value = ''
			descInputBox.value = ''
		})
})

fetch('http://localhost:8080/todos/')
	.then((res) => res.json())
	.then((data) => {
		data.forEach((el) => {
			const li = document.createElement('li')
			const title = document.createElement('div')
			title.appendChild(document.createTextNode(el.title))
			li.appendChild(title)
			const description = document.createElement('div')
			description.appendChild(document.createTextNode(el.description))
			li.appendChild(description)
			li.classList.add('todo')
			li.setAttribute('data-id', el.id)
			li.addEventListener('click', async () => {
				if (confirm('Do you want to update this item?')) {
					const newDesc = prompt('Update description to?')
					await fetch(`http://localhost:8080/todos/${Number(el.id)}`, {
						method: 'PUT',
						headers: new Headers({
							'Content-Type': 'application/json',
						}),
						body: newDesc,
					})
					if (newDesc)
						li.querySelector('div:nth-child(2)').textContent = newDesc
				} else if (confirm('Do you want to delete this item?')) {
					list.removeChild(document.querySelector(`[data-id='${el.id}']`))
					fetch(`http://localhost:8080/todos/${Number(el.id)}`, {
						method: 'DELETE',
					})
				}
			})
            list.appendChild(li)
		})
	})
